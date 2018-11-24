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
    //@Column
    //private String idDepartamento;
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

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

    public Departamento getDepartamento() { return departamento; }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
