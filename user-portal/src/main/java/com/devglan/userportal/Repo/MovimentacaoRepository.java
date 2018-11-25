package com.devglan.userportal.Repo;

import com.devglan.userportal.Models.Movimentacao;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MovimentacaoRepository extends Repository<Movimentacao, Integer> {
    void delete(Movimentacao mov);

    List<Movimentacao> findAll();

    Movimentacao findOne(int id);

    Movimentacao save(Movimentacao mov);
}