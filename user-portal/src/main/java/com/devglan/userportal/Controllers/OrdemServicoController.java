package com.devglan.userportal.Controllers;

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
		
		if (bem.getSituacao() == Situacao.INCORPORADO) {
			bem.setSituacao(Situacao.EM_CONSERTO);
			ordemServico.setBem(bem);
			ordemServico.setSituacao(SituacaoServico.EM_CONSERTO);
			bemService.update(bem);
			return service.save(ordemServico);
		} 
		return null;
	}
	
	@PutMapping(path = "/concluir/{id}")
	public OrdemServico concluir(@RequestBody OrdemServico ordemServico) {
		Bem bem = ordemServico.getBem();
		if (bem.getSituacao() == Situacao.EM_CONSERTO 
				&& ordemServico.getSituacao() == SituacaoServico.EM_CONSERTO) {
			bem.setSituacao(Situacao.INCORPORADO);
			ordemServico.setBem(bem);
			ordemServico.setSituacao(SituacaoServico.CONCLUIDA);
			bemService.update(bem);
			return service.save(ordemServico);
		}
		return null;
	}
	
	@PutMapping(path = "/update/{id}")
	public OrdemServico update(@RequestBody OrdemServico ordemServico) {
		OrdemServico ordem = service.findOne(ordemServico.getId());
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
	     return service.findAll();
	 }
	
}
