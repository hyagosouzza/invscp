package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Bem;

import java.util.List;

public interface BemService {
    Bem create(Bem bem);

    Bem delete(int id);

    List<Bem> findAll();

    Bem findById(int id);

    Bem update(Bem bem);
}
