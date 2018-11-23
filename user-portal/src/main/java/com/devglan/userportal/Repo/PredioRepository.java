package com.devglan.userportal.Repo;

import com.devglan.userportal.Models.Predio;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PredioRepository extends Repository<Predio, Integer> {
    void delete(Predio predio);

    List<Predio> findAll();

    Predio findOne(int id);

    Predio save(Predio predio);
}
