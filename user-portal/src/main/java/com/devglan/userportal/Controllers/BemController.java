package com.devglan.userportal.Controllers;

import com.devglan.userportal.Enums.Situacao;
import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Models.HistoricoBp;
import com.devglan.userportal.Services.BemService;
import com.devglan.userportal.Services.MovimentacaoService;
import com.devglan.userportal.Services.OrdemServicoService;
import com.devglan.userportal.Services.SalaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.devglan.userportal.Enums.Situacao.BAIXADO;
import static com.devglan.userportal.Enums.Situacao.INCORPORADO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/bens"})
public class BemController {
    @Autowired
    private BemService bemService;
    @Autowired
    private SalaService salaService;
    @Autowired
    private MovimentacaoService movServ;
    @Autowired
    private OrdemServicoService ordmServ;

    @PostMapping
    public Bem create(@RequestBody Bem bem){
        if(bem.getSala() == null) {
            bem.setSala(salaService.findById(17));
        }
        bem.setSituacao(INCORPORADO);
        return bemService.create(bem);
    }

    @GetMapping(path = {"/{id}"})
    public Bem findOne(@PathVariable("id") int id){
        return bemService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Bem update(@PathVariable("id") int id, @RequestBody Bem bem){
        bem.setId(id);
        return bemService.update(bem);
    }

    @PutMapping(path = {"/baixar/{id}"})
    public Bem baixar(@PathVariable("id") int id, @RequestBody Bem bem){
        bem.setId(id);
        bem.setSituacao(BAIXADO);
        return bemService.update(bem);
    }

    @DeleteMapping(path ={"/{id}"})
    public Bem delete(@PathVariable("id") int id) {
        return bemService.delete(id);
    }

    @GetMapping
    public List<Bem> findAll(){
        return bemService.findAll();
    }

    @GetMapping(path = {"/numTomb/{numTombamento}"})
    public List<Bem> findAllByNumTombamento(@PathVariable("numTombamento") String numTombamento) { return bemService.findAllByNumTombamento(numTombamento); }

    @GetMapping(path = {"/marca/{marca}"})
    public List<Bem> findAllByMarca(@PathVariable("marca") String marca) { return bemService.findAllByMarca(marca); }

    @GetMapping(path = {"/denomi/{denominacao}"})
    public List<Bem> findAllByDenominacao(@PathVariable("denominacao") String denominacao) { return bemService.findAllByDenominacao(denominacao); }

    @GetMapping(path = {"/inventario"})
    public List<Bem> findInventario() throws ParseException { return bemService.findInventario(); }

    @GetMapping(path = {"/relat/{sala}"})
    public List<Bem> findAllBySalaGm(@PathVariable("sala") String sala) { return bemService.findAllBySalaGm(sala);}

    @GetMapping(path = {"/hist/{id}"})
    public HistoricoBp historico(@PathVariable("id")  int id) {
    	HistoricoBp historico = new HistoricoBp();
    	historico.setBem(bemService.findById(id));
    	historico.setMovimentacoes(movServ.findByBem(historico.getBem()));
    	historico.setOrdens(ordmServ.findByBem(historico.getBem()));
    	historico.getMovimentacoes().stream().sorted((o1, o2)-> {
    		return o1.getDataSaida().compareTo(o2.getDataEntrada());
    	});
    	historico.getOrdens().stream().sorted((o1, o2)-> {
    		return o1.getDataAbertura().compareTo(o2.getDataAbertura());
    	});
        return historico;
    }
    
    @GetMapping(path = {"/incorps"})
    public List<Bem> findAllIncorp(){
    	List<Bem> bens = bemService.findAll();
    	List<Bem> bens1 = new ArrayList<>();
    	for (Bem bem : bens) {
			if(bem.getSituacao() == Situacao.INCORPORADO) {
				bens1.add(bem);
			}
		}
        return bens1;
    }
}
