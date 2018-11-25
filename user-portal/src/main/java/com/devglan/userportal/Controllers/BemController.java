package com.devglan.userportal.Controllers;

import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Services.BemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.devglan.userportal.Enums.Situacao.INCORPORADO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/bens"})
public class BemController {
    @Autowired
    private BemService bemService;

    @PostMapping
    public Bem create(@RequestBody Bem bem){
        if(bem.getIdSala() == null) {
            bem.setIdSala("3");
        }
        bem.setSituacao(INCORPORADO);
        return bemService.create(bem);
    }

    @GetMapping(path = {"/{id}"})
    public Bem findOne(@PathVariable("id") int id){
        return bemService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Bem update(@PathVariable("id") int id, @RequestBody Bem bem){
        bem.setId(id);
        return bemService.update(bem);
    }

    @DeleteMapping(path ={"/{id}"})
    public Bem delete(@PathVariable("id") int id) {
        return bemService.delete(id);
    }

    @GetMapping
    public List<Bem> findAll(){
        return bemService.findAll();
    }

    @GetMapping(path = {"/numTomb/{numTombamento}"})
    public List<Bem> findAllByNumTombamento(@PathVariable("numTombamento") String numTombamento) { return bemService.findAllByNumTombamento(numTombamento); }

    @GetMapping(path = {"/marca/{marca}"})
    public List<Bem> findAllByMarca(@PathVariable("marca") String marca) { return bemService.findAllByMarca(marca); }

    @GetMapping(path = {"/denomi/{denominacao}"})
    public List<Bem> findAllByDenominacao(@PathVariable("denominacao") String denominacao) { return bemService.findAllByDenominacao(denominacao); }

}
