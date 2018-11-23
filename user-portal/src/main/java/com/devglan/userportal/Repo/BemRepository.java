package com.devglan.userportal.Repo;

import com.devglan.userportal.Models.Bem;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BemRepository extends Repository<Bem, Integer> {
    void delete(Bem bem);

    List<Bem> findAll();

    Bem findOne(int id);

    Bem save(Bem bem);
}
