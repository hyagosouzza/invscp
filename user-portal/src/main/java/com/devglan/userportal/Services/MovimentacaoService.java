package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Movimentacao;

import java.util.List;

public interface MovimentacaoService {
    Movimentacao create(Movimentacao mov);

    Movimentacao delete(int id);

    List<Movimentacao> findAll();

    Movimentacao findById(int id);

    Movimentacao update(Movimentacao mov);
}
