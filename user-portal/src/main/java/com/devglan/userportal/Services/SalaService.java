package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Sala;

import java.util.List;

public interface SalaService {
    Sala create(Sala sala);

    Sala delete(int id);

    List<Sala> findAll();

    Sala findById(int id);

    Sala update(Sala sala);

    List<Sala> findAllPerDepart(String depart);
}
