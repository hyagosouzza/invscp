package com.devglan.userportal.Models;

import javax.persistence.*;

@Entity
@Table(name = "predio")
public class Predio {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    //@Column
    //private String idLocal;
    @ManyToOne
    @JoinColumn(name = "id_local")
    private Local local;

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

    public Local getLocal() { return local; }

    public void setLocal(Local local) { this.local = local; }

}
