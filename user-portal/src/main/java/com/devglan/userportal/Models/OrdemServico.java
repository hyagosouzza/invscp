package com.devglan.userportal.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.devglan.userportal.Enums.SituacaoServico;


@Entity
@Table(name = "ordem_de_servico")
public class OrdemServico {
	
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;
	@Temporal(TemporalType.DATE)
	private Date dataFechamento;
	@ManyToOne
    @JoinColumn(name = "bem_patrimonial")
	private Bem bem;
	@Column
	private String motivo;
	@Column
	private String prestadoraDeServico;
	
	private float valor;
	@Enumerated(EnumType.STRING)
	private SituacaoServico situacao;
	
	public OrdemServico() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getPrestadoraDeServico() {
		return prestadoraDeServico;
	}

	public void setPrestadoraDeServico(String prestadoraDeServico) {
		this.prestadoraDeServico = prestadoraDeServico;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public SituacaoServico getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoServico situacao) {
		this.situacao = situacao;
	}

	public Bem getBem() {
		return bem;
	}

	public void setBem(Bem bem) {
		this.bem = bem;
	}

}
