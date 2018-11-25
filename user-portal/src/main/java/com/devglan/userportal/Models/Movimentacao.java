package com.devglan.userportal.Models;

import com.devglan.userportal.Enums.Etapa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Etapa etapa;
    @ManyToOne
    @JoinColumn(name = "bem_patrimonial")
    private Bem bem;
    @ManyToOne
    @JoinColumn(name = "sala_origem")
    private Sala origem;
    @ManyToOne
    @JoinColumn(name = "sala_destino")
    private Sala destino;
    @ManyToOne
    @JoinColumn(name = "solicitante")
    private User solicitante;
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @ManyToOne
    @JoinColumn(name = "aprovador_saida")
    private User aprovador_saida;
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @ManyToOne
    @JoinColumn(name = "aprovador_entrada")
    private User aprovador_entrada;
    @Temporal(TemporalType.DATE)
    private Date dataCancelamento;
    @ManyToOne
    @JoinColumn(name = "user_cancelamento")
    private User userCancelamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Bem getBem() {
        return bem;
    }

    public void setBem(Bem bem) {
        this.bem = bem;
    }

    public Sala getOrigem() {
        return origem;
    }

    public void setOrigem(Sala origem) {
        this.origem = origem;
    }

    public Sala getDestino() {
        return destino;
    }

    public void setDestino(Sala destino) {
        this.destino = destino;
    }

    public User getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(User solicitante) {
        this.solicitante = solicitante;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public User getAprovador_saida() {
        return aprovador_saida;
    }

    public void setAprovador_saida(User aprovador_saida) {
        this.aprovador_saida = aprovador_saida;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public User getAprovador_entrada() {
        return aprovador_entrada;
    }

    public void setAprovador_entrada(User aprovador_entrada) {
        this.aprovador_entrada = aprovador_entrada;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public User getUserCancelamento() {
        return userCancelamento;
    }

    public void setUserCancelamento(User userCancelamento) {
        this.userCancelamento = userCancelamento;
    }
}
