package com.devglan.userportal.Models;

import com.devglan.userportal.Enums.ProfileEnum;

public class SolicitacaoMovimentacao {
    private Bem bem;
    private Sala destino;
    private User solicitante;

    public boolean isChefe() {
        return this.solicitante.getProfile().equals(ProfileEnum.CHEFE_DEPART);
    }

    public boolean isInternalMov() {
        return this.bem.getSala().getDepartamento()
                .equals(this.destino.getDepartamento());
    }

    public boolean isCrossCity() {
        return !this.bem.getLocal().getCidade().equals(this.destino.getLocal().getCidade());
    }

    public Bem getBem() {
        return bem;
    }

    public void setBem(Bem bem) {
        this.bem = bem;
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
