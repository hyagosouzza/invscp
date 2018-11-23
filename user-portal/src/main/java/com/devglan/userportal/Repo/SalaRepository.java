package com.devglan.userportal.Repo;

import com.devglan.userportal.Models.Sala;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SalaRepository extends Repository<Sala, Integer> {
    void delete(Sala sala);

    List<Sala> findAll();

    Sala findOne(int id);

    Sala save(Sala sala);
}
