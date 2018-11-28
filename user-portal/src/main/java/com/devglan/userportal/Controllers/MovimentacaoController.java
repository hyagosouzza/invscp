package com.devglan.userportal.Controllers;

import com.devglan.userportal.Enums.Etapa;
import com.devglan.userportal.Enums.ProfileEnum;
import com.devglan.userportal.Models.AcaoMovimentacao;
import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Models.Movimentacao;
import com.devglan.userportal.Models.SolicitacaoMovimentacao;
import com.devglan.userportal.Services.BemService;
import com.devglan.userportal.Services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
        Bem bemPatrimonial = solicitacao.getBemPatrimonial();

        mov.setBem(solicitacao.getBemPatrimonial());
        mov.setSolicitante(solicitacao.getSolicitante());
        mov.setOrigem(bemPatrimonial.getSala());
        mov.setDestino(solicitacao.getDestino());

        //Caso o solicitante seja o chefe do departamento, o aceite de saída será automático
        if (solicitacao.getSolicitante().getProfile().equals(ProfileEnum.CHEFE_DEPART)) {
            mov.setEtapa(Etapa.AC_ENTRADA);
            mov.setDataSaida(new Date());
            mov.setAprovadorSaida(solicitacao.getSolicitante());
        } else {
            mov.setEtapa(Etapa.AC_SAIDA);
        }

        //RF 2 - Movimentação de Bem Patrimonial Interna - MBPi
        if (bemPatrimonial.getSala().getDepartamento().equals(solicitacao.getDestino().getDepartamento())) {
            mov.setDataSaida(new Date());
            mov.setAprovadorSaida(solicitacao.getSolicitante());
            mov.setDataEntrada(new Date());
            mov.setAprovadorEntrada(solicitacao.getSolicitante());
            mov.setEtapa(Etapa.FINALIZADA);
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
    public boolean aceiteSaida(@PathVariable("id") int id, @RequestBody AcaoMovimentacao acao) {
        Movimentacao movimentacao = acao.getMovimentacao();

        movimentacao.setId(id);
        movimentacao.setAprovadorSaida(acao.getSolicitante());
        movimentacao.setDataSaida(new Date());
        movimentacao.setEtapa(Etapa.AC_ENTRADA);

        return movimentacaoService.update(movimentacao) != null;
    }

    @PutMapping(path = {"/aceite-entrada/{id}"})
    public boolean aceiteEntrada(@PathVariable("id") int id, @RequestBody AcaoMovimentacao acao) {
        Movimentacao movimentacao = acao.getMovimentacao();
        Bem bemPatrimonial = movimentacao.getBem();

        movimentacao.setId(id);
        movimentacao.setAprovadorEntrada(acao.getSolicitante());
        movimentacao.setDataEntrada(new Date());
        movimentacao.setEtapa(Etapa.FINALIZADA);

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
}