package com.devglan.userportal.Controllers;

import com.devglan.userportal.Models.Movimentacao;
import com.devglan.userportal.Services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/movimentacoes"})
public class MovimentacaoController {
    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao create(@RequestBody Movimentacao mov){
        return movimentacaoService.create(mov);
    }

    @GetMapping(path = {"/{id}"})
    public Movimentacao findOne(@PathVariable("id") int id){
        return movimentacaoService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Movimentacao update(@PathVariable("id") int id, @RequestBody Movimentacao movimentacao){
        movimentacao.setId(id);
        return movimentacaoService.update(movimentacao);
    }

    @DeleteMapping(path ={"/{id}"})
    public Movimentacao delete(@PathVariable("id") int id) {
        return movimentacaoService.delete(id);
    }

    @GetMapping
    public List<Movimentacao> findAll(){
        return movimentacaoService.findAll();
    }
}