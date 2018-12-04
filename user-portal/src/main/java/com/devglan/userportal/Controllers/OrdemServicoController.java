package com.devglan.userportal.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.userportal.Enums.Situacao;
import com.devglan.userportal.Enums.SituacaoServico;
import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Models.OrdemServico;
import com.devglan.userportal.Services.BemServiceImpl;
import com.devglan.userportal.Services.OrdemServicoServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/ordens"})
public class OrdemServicoController {

	@Autowired
	private OrdemServicoServiceImpl service;
	
	@Autowired
	private BemServiceImpl bemService;

    @PostMapping
    public OrdemServico create(@RequestBody OrdemServico ordemServico) {
    	Bem bem = bemService.findById(ordemServico.getBem().getId());
    	OrdemServico ordem = new OrdemServico();
    	if (bem.getSituacao() == Situacao.EM_CONSERTO || bem.getSituacao() == Situacao.BAIXADO) {
    		return null;
		} else {
			bem.setSituacao(Situacao.EM_CONSERTO);
			ordemServico.setBem(bem);
			ordemServico.setSituacao(SituacaoServico.EM_CONSERTO);
			ordem = service.save(ordemServico);
			if(ordem != null) {
				bemService.update(bem);
			}
			System.out.println(ordem.toString());
			return ordem;
		}
    }

	
    @PutMapping(path = "/concluir/{id}")
	public OrdemServico concluir(@RequestBody OrdemServico ordemServico, @PathVariable("id") int id) {
		Bem bem = ordemServico.getBem();
		OrdemServico ordem = service.findOne(id);
		ordem.setDataAbertura(ordemServico.getDataAbertura());
		ordem.setDataFechamento(ordemServico.getDataFechamento());
		ordem.setMotivo(ordemServico.getMotivo());
		ordem.setPrestadoraDeServico(ordemServico.getPrestadoraDeServico());
		ordem.setValor(ordemServico.getValor());
		bem.setSituacao(Situacao.INCORPORADO);
		ordem.setBem(bem);
		ordem.setSituacao(SituacaoServico.CONCLUIDA);
		bemService.update(bem);
		return service.save(ordem);
	}
	
	@PutMapping(path = "/update/{id}")
	public OrdemServico update(@PathVariable("id") int id, @RequestBody OrdemServico ordemServico) {
		OrdemServico ordem = service.findOne(id);
		ordem.setDataAbertura(ordemServico.getDataAbertura());
		ordem.setDataFechamento(ordem.getDataFechamento());
		ordem.setMotivo(ordemServico.getMotivo());
		ordem.setPrestadoraDeServico(ordemServico.getPrestadoraDeServico());
		ordem.setValor(ordemServico.getValor());
		return service.save(ordem);
	}
	
	@GetMapping(path = {"/{id}"})
	public OrdemServico findOne(@PathVariable("id") int id) {
		return service.findOne(id);
	}
	
	 @DeleteMapping(path = {"/{id}"})
	 public OrdemServico delete(@PathVariable("id") int id) {
		 OrdemServico ordem = service.findOne(id);
	     return service.delete(ordem);
	 }

	 @GetMapping
	 public List<OrdemServico> findAll() {
		 List<OrdemServico> list = service.findAll();
		 List<OrdemServico> list1 = new ArrayList<OrdemServico>();
		 for (OrdemServico ordemServico : list) {
			if(ordemServico.getSituacao() != SituacaoServico.CONCLUIDA) {
				list1.add(ordemServico);
			}
		}
	     return list1;
	 }
	
}
