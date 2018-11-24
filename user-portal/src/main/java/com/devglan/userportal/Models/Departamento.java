package com.devglan.userportal.Models;

import javax.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    //@Column
    //private String idPredio;
    @ManyToOne
    @JoinColumn(name = "id_predio")
    private Predio predio;

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

    public Predio getPredio() { return predio; }

    public void setPredio(Predio predio) { this.predio = predio; }

    /*public String getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(String idPredio) {
        this.idPredio = idPredio;
    }*/


}
