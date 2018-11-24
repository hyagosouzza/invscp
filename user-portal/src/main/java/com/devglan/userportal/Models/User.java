package com.devglan.userportal.Models;

import com.devglan.userportal.Enums.ProfileEnum;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String senha;
    @Column
    private String email;
    @Enumerated(EnumType.STRING)
    private ProfileEnum profile;
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }

    public Departamento getDepartamento() { return departamento; }

    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
}
