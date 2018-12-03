package com.devglan.userportal.Repo;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Models.OrdemServico;

public interface OrdemServicoRepository extends Repository<OrdemServico, Integer>{

	OrdemServico delete(OrdemServico ordemServico);
	
	List<OrdemServico> findByBem(Bem bem);

    List<OrdemServico> findAll();

    OrdemServico findOne(int id);

    OrdemServico save(OrdemServico ordemServico);
	
}
