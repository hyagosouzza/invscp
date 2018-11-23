package com.devglan.userportal.Models;

import javax.persistence.*;

@Entity
@Table(name = "sala")
public class Sala {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String num;
    @Column
    private String idDepartamento;


    public int getId() {
        return id;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

}
