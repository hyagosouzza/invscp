package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Departamento;

import java.util.List;

public interface DepartamentoService {
    Departamento create(Departamento departamento);

    Departamento delete(int id);

    List<Departamento> findAll();

    Departamento findById(int id);

    Departamento update(Departamento departamento);
}
