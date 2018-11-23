package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Departamento;
import com.devglan.userportal.Repo.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
    @Autowired
    private DepartamentoRepository repository;

    @Override
    public Departamento create(Departamento departamento) {
        return repository.save(departamento);
    }

    @Override
    public Departamento delete(int id) {
        Departamento departamento = findById(id);
        if(departamento != null){
            repository.delete(departamento);
        }
        return departamento;
    }

    @Override
    public List<Departamento> findAll() {
        return repository.findAll();
    }

    @Override
    public Departamento findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Departamento update(Departamento departamento) {
        return repository.save(departamento);
    }
}
