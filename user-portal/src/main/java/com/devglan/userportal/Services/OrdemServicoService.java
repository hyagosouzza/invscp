package com.devglan.userportal.Services;

import java.util.List;

import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Models.OrdemServico;

public interface OrdemServicoService {
	
	OrdemServico delete(OrdemServico ordemServico);

	List<OrdemServico> findByBem(Bem bem);

	List<OrdemServico> findAll();

	OrdemServico findOne(int id);

	OrdemServico save(OrdemServico ordemServico);

}
