package com.devglan.userportal.Models;

import java.util.List;

public class HistoricoBp {
	
	private Bem bem;
	private List<Movimentacao> movimentacoes;
	private List<OrdemServico> ordens;
	
	public HistoricoBp() {
	}

	public Bem getBem() {
		return bem;
	}

	public void setBem(Bem bem) {
		this.bem = bem;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public List<OrdemServico> getOrdens() {
		return ordens;
	}

	public void setOrdens(List<OrdemServico> ordens) {
		this.ordens = ordens;
	}
	
}
