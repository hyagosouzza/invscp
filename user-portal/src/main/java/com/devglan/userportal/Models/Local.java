package com.devglan.userportal.Models;

import com.devglan.userportal.Enums.UnidadeEnum;

import javax.persistence.*;

@Entity
@Table(name = "local")
public class Local {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Enumerated(EnumType.STRING)
    private UnidadeEnum unidadeAdminstra;

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UnidadeEnum getUnidadeAdminstra() {
        return unidadeAdminstra;
    }

    public void setUnidadeAdminstra(UnidadeEnum unidadeAdminstra) {
        this.unidadeAdminstra = unidadeAdminstra;
    }
}
