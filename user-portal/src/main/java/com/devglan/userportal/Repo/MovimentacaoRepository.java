package com.devglan.userportal.Repo;

import com.devglan.userportal.Models.Departamento;
import com.devglan.userportal.Models.Movimentacao;
import com.devglan.userportal.Enums.Etapa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimentacaoRepository extends Repository<Movimentacao, Integer> {
    void delete(Movimentacao mov);

    List<Movimentacao> findAll();

    @Query("SELECT m FROM Movimentacao m  INNER JOIN m.destino s WHERE s.departamento = :departamento " +
                                                        "and m.etapa = com.devglan.userportal.Enums.Etapa.AC_ENTRADA")
    List<Movimentacao> findAllEntradas(@Param("departamento") Departamento departamento);

    @Query("SELECT m FROM Movimentacao m INNER JOIN m.origem s WHERE s.departamento = :departamento " +
                                                            "and m.etapa = com.devglan.userportal.Enums.Etapa.AC_SAIDA")
    List<Movimentacao> findAllSaidas(@Param("departamento") Departamento departamento);

    Movimentacao findOne(int id);

    Movimentacao save(Movimentacao mov);
}