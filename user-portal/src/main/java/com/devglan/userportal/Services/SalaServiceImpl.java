package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Sala;
import com.devglan.userportal.Repo.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaServiceImpl implements SalaService{
    @Autowired
    private SalaRepository repository;

    @Override
    public Sala create(Sala sala) {
        return repository.save(sala);
    }

    @Override
    public Sala delete(int id) {
        Sala sala = findById(id);
        if(sala != null){
            repository.delete(sala);
        }
        return sala;
    }

    @Override
    public List<Sala> findAll() {
        return repository.findAll();
    }

    @Override
    public Sala findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Sala update(Sala sala) {
        return repository.save(sala);
    }

    @Override
    public List<Sala> findAllPerDepart(String depart){
        List<Sala> listaTotal = repository.findAll();
        List<Sala> listaFiltrada = new ArrayList<>();

        for(int contador = 0; contador < listaTotal.size(); contador ++){
            if(listaTotal.get(contador).getDepartamento().getNome().equals(depart)){
                listaFiltrada.add(listaTotal.get(contador));
            }
        }
        return listaFiltrada;
    }
}
