package com.devglan.userportal.Models;

import com.devglan.userportal.Enums.ProfileEnum;

public class SolicitacaoMovimentacao {
    private Bem bemPatrimonial;
    private Sala destino;
    private User solicitante;

    public boolean isChefe() {
        return this.solicitante.getProfile().equals(ProfileEnum.CHEFE_DEPART);
    }

    public boolean isInternalMov() {
        return this.bemPatrimonial.getSala().getDepartamento()
                .equals(this.destino.getDepartamento());
    }

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
