package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Predio;

import java.util.List;

public interface PredioService {
    Predio create(Predio predio);

    Predio delete(int id);

    List<Predio> findAll();

    Predio findById(int id);

    Predio update(Predio predio);
}
