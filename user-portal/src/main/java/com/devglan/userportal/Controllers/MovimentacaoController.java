package com.devglan.userportal.Controllers;

import com.devglan.userportal.Enums.Etapa;
import com.devglan.userportal.Models.*;
import com.devglan.userportal.Services.BemService;
import com.devglan.userportal.Services.MovimentacaoService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public MovimentacaoResponse create(@RequestBody SolicitacaoMovimentacao solicitacao) {
        MovimentacaoResponse response = new MovimentacaoResponse();
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

            if (movimentacaoService.update(mov) != null) {
                response.setSuccess(true);
            } else {
                response.setSuccess(false);
            }
        }

        if (movimentacaoService.create(mov) != null) {
            // RF 6 - Emitir guia de autorização de transporte
            response.setSuccess(true);
            if (solicitacao.isCrossCity()) {
                try {
                    BufferedReader rd = new BufferedReader(new FileReader("./guia_autorizacao.html"));
                    String retorno = IOUtils.toString(rd);
                    retorno = retorno.replace("&cidade_origem&", bemPatrimonial.getLocal().getCidade());
                    retorno = retorno.replace("&estado_origem&", bemPatrimonial.getLocal().getEstado());
                    retorno = retorno.replace("&cidade_destino&", solicitacao.getDestino().getLocal().getCidade());
                    retorno = retorno.replace("&estado_destino&", solicitacao.getDestino().getLocal().getEstado());
                    retorno = retorno.replace("&denominacao&", bemPatrimonial.getDenominacao());
                    retorno = retorno.replace("&marca&", bemPatrimonial.getMarca());
                    retorno = retorno.replace("&numero_tombamento&", bemPatrimonial.getNumTombamento());
                    retorno = retorno.replace("&numero_nf&", bemPatrimonial.getNumNotaFiscal());

                    response.setCrossCity(true);
                    response.setHtml(retorno);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                response.setSuccess(true);
            }
        } else {
            response.setSuccess(false);
        }
        return response;
    }

    @GetMapping(path = {"/{id}"})
    public Movimentacao findOne(@PathVariable("id") int id) {
        return movimentacaoService.findById(id);
    }

    @PutMapping(path = {"/cancelar/{id}"})
    public boolean cancelar(@PathVariable("id") int id,
                               @RequestBody AcaoMovimentacao acao) {
        Movimentacao movimentacao = acao.getMovimentacao();

        movimentacao.setId(id);
        movimentacao.setUserCancelamento(acao.getSolicitante());
        movimentacao.setDataCancelamento(new Date());

        return movimentacaoService.update(movimentacao) != null;
    }

    @PutMapping(path = {"/aceite-saida/{id}"})
    public boolean aceiteSaida(@PathVariable("id") int id,
                               @RequestBody AcaoMovimentacao acao) {
        Movimentacao movimentacao = acao.getMovimentacao();

        movimentacao.setId(id);
        movimentacao.aceiteSaida(acao.getSolicitante());

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