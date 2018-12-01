package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Bem;

import java.text.ParseException;
import java.util.List;

public interface BemService {
    Bem create(Bem bem);

    Bem delete(int id);

    List<Bem> findAll();

    Bem findById(int id);

    Bem update(Bem bem);

    List<Bem> findAllByNumTombamento(String numTombamento);

    List<Bem> findAllByMarca(String marca);

    List<Bem> findAllByDenominacao(String denominacao);

    List<Bem> findInventario() throws ParseException;
}
