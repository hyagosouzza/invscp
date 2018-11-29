package com.devglan.userportal.Models;

import com.devglan.userportal.Enums.Etapa;

import javax.persistence.*;
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
    private User aprovadorSaida;
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @ManyToOne
    @JoinColumn(name = "aprovador_entrada")
    private User aprovadorEntrada;
    @Temporal(TemporalType.DATE)
    private Date dataCancelamento;
    @ManyToOne
    @JoinColumn(name = "user_cancelamento")
    private User userCancelamento;

    public void execInternalMov(User user) {
        this.aceiteSaida(user);
        this.aceiteEntrada(user);
    }

    public void aceiteSaida(User user) {
        this.setEtapa(Etapa.AC_ENTRADA);
        this.setDataSaida(new Date());
        this.setAprovadorSaida(user);
    }

    public void aceiteEntrada(User user) {
        this.setEtapa(Etapa.FINALIZADA);
        this.setDataEntrada(new Date());
        this.setAprovadorEntrada(user);
    }

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

    public User getAprovadorSaida() {
        return aprovadorSaida;
    }

    public void setAprovadorSaida(User aprovadorSaida) {
        this.aprovadorSaida = aprovadorSaida;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public User getAprovadorEntrada() {
        return aprovadorEntrada;
    }

    public void setAprovadorEntrada(User aprovadorEntrada) {
        this.aprovadorEntrada = aprovadorEntrada;
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
