package com.devglan.userportal.Models;

import com.devglan.userportal.Enums.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bem")
public class Bem {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dataAquis;
    @Temporal(TemporalType.DATE)
    private Date dataDaBaixa;
    @Temporal(TemporalType.DATE)
    private Date garantia;
    @Temporal(TemporalType.DATE)
    private Date vidaUtil;
    @Column
    private String especificacao;
    @Column
    private String marca;
    @Column
    private String numNotaFiscal;
    @Column
    private String numTombamento;
    @Column
    private String obsrBaixa;
    @Column
    private Float valorAtual;
    @Column
    private Float valorCompra;
    @Column
    private String denominacao;
    @Enumerated(EnumType.STRING)
    private CatDepre catDepre;
    @Enumerated(EnumType.STRING)
    private GrupoMaterialEnum grupoMaterial;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
    @Enumerated(EnumType.STRING)
    private MotivoBaixa motivoDaBaixa;
    @ManyToOne
    @JoinColumn(name = "sala_atual")
    private Sala sala;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public Date getDataAquis() {
        return dataAquis;
    }

    public void setDataAquis(Date dataAquis) {
        this.dataAquis = dataAquis;
    }

    public Date getDataDaBaixa() {
        return dataDaBaixa;
    }

    public void setDataDaBaixa(Date dataDaBaixa) {
        this.dataDaBaixa = dataDaBaixa;
    }

    public Date getGarantia() {
        return garantia;
    }

    public void setGarantia(Date garantia) {
        this.garantia = garantia;
    }

    public Date getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Date vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumNotaFiscal() {
        return numNotaFiscal;
    }

    public void setNumNotaFiscal(String numNotaFiscal) {
        this.numNotaFiscal = numNotaFiscal;
    }

    public String getNumTombamento() {
        return numTombamento;
    }

    public void setNumTombamento(String numTombamento) {
        this.numTombamento = numTombamento;
    }

    public String getObsrBaixa() {
        return obsrBaixa;
    }

    public void setObsrBaixa(String obsrBaixa) {
        this.obsrBaixa = obsrBaixa;
    }

    public Float getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Float valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public CatDepre getCatDepre() {
        return catDepre;
    }

    public void setCatDepre(CatDepre catDepre) {
        this.catDepre = catDepre;
    }

    public GrupoMaterialEnum getGrupoMaterial() {
        return grupoMaterial;
    }

    public void setGrupoMaterial(GrupoMaterialEnum grupoMaterial) {
        this.grupoMaterial = grupoMaterial;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public MotivoBaixa getMotivoDaBaixa() {
        return motivoDaBaixa;
    }

    public void setMotivoDaBaixa(MotivoBaixa motivoDaBaixa) {
        this.motivoDaBaixa = motivoDaBaixa;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
