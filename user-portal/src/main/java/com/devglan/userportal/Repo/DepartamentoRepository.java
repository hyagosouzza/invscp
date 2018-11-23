package com.devglan.userportal.Repo;

import com.devglan.userportal.Models.Departamento;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DepartamentoRepository extends Repository<Departamento, Integer> {
    void delete(Departamento departamento);

    List<Departamento> findAll();

    Departamento findOne(int id);

    Departamento save(Departamento departamento);
}
