package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Local;
import com.devglan.userportal.Repo.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalServiceImpl implements LocalService{
    @Autowired
    private LocalRepository repository;

    @Override
    public Local create(Local local) {
        return repository.save(local);
    }

    @Override
    public Local delete(int id) {
        Local local = findById(id);
        if(local != null){
            repository.delete(local);
        }
        return local;
    }

    @Override
    public List<Local> findAll() {
        return repository.findAll();
    }

    @Override
    public Local findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Local update(Local local) {
        return repository.save(local);
    }
}
