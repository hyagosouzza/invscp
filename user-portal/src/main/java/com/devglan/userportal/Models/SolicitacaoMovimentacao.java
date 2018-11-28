package com.devglan.userportal.Models;

public class SolicitacaoMovimentacao {
    private Bem bemPatrimonial;
    private Sala destino;
    private User solicitante;

    public Bem getBemPatrimonial() {
        return bemPatrimonial;
    }

    public void setBemPatrimonial(Bem bemPatrimonial) {
        this.bemPatrimonial = bemPatrimonial;
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
}
