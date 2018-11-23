package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Predio;
import com.devglan.userportal.Repo.PredioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredioServiceImpl implements PredioService{
    @Autowired
    private PredioRepository repository;

    @Override
    public Predio create(Predio predio) {
        return repository.save(predio);
    }

    @Override
    public Predio delete(int id) {
        Predio predio = findById(id);
        if(predio != null){
            repository.delete(predio);
        }
        return predio;
    }

    @Override
    public List<Predio> findAll() {
        return repository.findAll();
    }

    @Override
    public Predio findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Predio update(Predio predio) {
        return repository.save(predio);
    }
}
