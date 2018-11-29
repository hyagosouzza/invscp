package com.devglan.userportal.Services;

import com.devglan.userportal.Models.Departamento;
import com.devglan.userportal.Models.Movimentacao;
import com.devglan.userportal.Repo.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{
    @Autowired
    private MovimentacaoRepository repository;

    @Override
    public Movimentacao create(Movimentacao mov) {
        return repository.save(mov);
    }

    @Override
    public Movimentacao delete(int id) {
        Movimentacao mov = findById(id);
        if(mov != null){
            repository.delete(mov);
        }
        return mov;
    }

    @Override
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

   /* @Override
    public List<Movimentacao> findAllEntradas(Departamento departamento) {
        return repository.findAllEntradas(departamento);
    }

    @Override
    public List<Movimentacao> findAllSaidas(Departamento departamento) {
        return repository.findAllSaidas(departamento);
    }*/

    @Override
    public Movimentacao findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Movimentacao update(Movimentacao mov) {
        return repository.save(mov);
    }
}
