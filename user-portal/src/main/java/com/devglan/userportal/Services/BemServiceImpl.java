package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Repo.BemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BemServiceImpl implements BemService{
    @Autowired
    private BemRepository repository;

    @Override
    public Bem create(Bem bem) {
        return repository.save(bem);
    }

    @Override
    public Bem delete(int id) {
        Bem bem = findById(id);
        if(bem != null){
            repository.delete(bem);
        }
        return bem;
    }

    @Override
    public List<Bem> findAll() {
        return repository.findAll();
    }

    @Override
    public Bem findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Bem update(Bem bem) {
        return repository.save(bem);
    }
}
