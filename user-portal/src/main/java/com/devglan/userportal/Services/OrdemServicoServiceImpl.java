package com.devglan.userportal.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Models.OrdemServico;
import com.devglan.userportal.Repo.OrdemServicoRepository;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

	@Autowired
	private OrdemServicoRepository repository;
	
	@Autowired
	private BemService bemService;
	
	@Override
	public OrdemServico delete(OrdemServico ordemServico) {
		return repository.delete(ordemServico);
	}

	@Override
	public List<OrdemServico> findByBem(Bem bem) {
		Bem b = bemService.findById(bem.getId());
		return repository.findByBem(b);
	}

	@Override
	public List<OrdemServico> findAll() {
		return repository.findAll();
	}

	@Override
	public OrdemServico findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	public OrdemServico save(OrdemServico ordemServico) {
		return repository.save(ordemServico);
	}

	@Override
    public OrdemServico update(OrdemServico ordem) {
        return repository.save(ordem);
    }

}
