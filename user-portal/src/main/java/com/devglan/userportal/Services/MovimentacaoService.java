package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Models.Departamento;
import com.devglan.userportal.Models.Movimentacao;

import java.util.List;

public interface MovimentacaoService {
    Movimentacao create(Movimentacao mov);

    Movimentacao delete(int id);

    List<Movimentacao> findAll();
    
    List<Movimentacao> findByBem(Bem bem);

    List<Movimentacao> findAllEntradas(Departamento departamento);

    List<Movimentacao> findAllSaidas(Departamento departamento);

    Movimentacao findById(int id);

    Movimentacao update(Movimentacao mov);
}
