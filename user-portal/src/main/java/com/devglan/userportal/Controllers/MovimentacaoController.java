package com.devglan.userportal.Controllers;

import com.devglan.userportal.Enums.Etapa;
import com.devglan.userportal.Models.*;
import com.devglan.userportal.Services.BemService;
import com.devglan.userportal.Services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/movimentacoes"})
public class MovimentacaoController {
    @Autowired
    private MovimentacaoService movimentacaoService;
    @Autowired
    private BemService bemPatrimonialService;

    @PostMapping(path = "/registrar")
    public boolean create(@RequestBody SolicitacaoMovimentacao solicitacao) {
        Movimentacao mov = new Movimentacao();
        Bem bemPatrimonial = solicitacao.getBem();

        mov.setBem(solicitacao.getBem());
        mov.setSolicitante(solicitacao.getSolicitante());
        mov.setOrigem(bemPatrimonial.getSala());
        mov.setDestino(solicitacao.getDestino());

        //Caso o solicitante seja o chefe do departamento, o aceite de saída será automático
        if (solicitacao.isChefe()) {
            mov.aceiteSaida(solicitacao.getSolicitante());
        } else {
            mov.setEtapa(Etapa.AC_SAIDA);
        }

        //RF 2 - Movimentação de Bem Patrimonial Interna - MBPi
        if (solicitacao.isInternalMov()) {
            mov.execInternalMov(solicitacao.getSolicitante());
            bemPatrimonial.setSala(solicitacao.getDestino());

            return movimentacaoService.update(mov) != null &&
                    bemPatrimonialService.update(bemPatrimonial) != null;
        }

        return movimentacaoService.create(mov) != null;
    }

    @GetMapping(path = {"/{id}"})
    public Movimentacao findOne(@PathVariable("id") int id) {
        return movimentacaoService.findById(id);
    }

    @PutMapping(path = {"/aceite-saida/{id}"})
    public boolean aceiteSaida(@PathVariable("id") int id,
                               @RequestBody AcaoMovimentacao acao) {
        Movimentacao movimentacao = acao.getMovimentacao();

        movimentacao.setId(id);
        movimentacao.aceiteSaida(acao.getSolicitante());

        System.out.println(movimentacao.getEtapa());

        return movimentacaoService.update(movimentacao) != null;
    }

    @PutMapping(path = {"/aceite-entrada/{id}"})
    public boolean aceiteEntrada(@PathVariable("id") int id,
                                 @RequestBody AcaoMovimentacao acao) {
        Movimentacao movimentacao = acao.getMovimentacao();
        Bem bemPatrimonial = movimentacao.getBem();

        movimentacao.setId(id);
        movimentacao.aceiteEntrada(acao.getSolicitante());

        bemPatrimonial.setSala(movimentacao.getDestino());

        return movimentacaoService.update(movimentacao) != null &&
                bemPatrimonialService.update(bemPatrimonial) != null;
    }

    @DeleteMapping(path = {"/{id}"})
    public Movimentacao delete(@PathVariable("id") int id) {
        return movimentacaoService.delete(id);
    }

    @GetMapping
    public List<Movimentacao> findAll() {
        return movimentacaoService.findAll();
    }

    @PostMapping(path = {"/saidas"})
    public List<Movimentacao> findAllSaidas(@RequestBody Departamento departamento) {
        return movimentacaoService.findAllSaidas(departamento);
    }

    @PostMapping(path = {"/entradas"})
    public List<Movimentacao> findAllEntradas(@RequestBody Departamento departamento) {
        return movimentacaoService.findAllEntradas(departamento);
    }
}