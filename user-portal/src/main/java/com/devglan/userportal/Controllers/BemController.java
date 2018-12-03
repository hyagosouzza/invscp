package com.devglan.userportal.Controllers;

import com.devglan.userportal.Models.Bem;
import com.devglan.userportal.Models.Sala;
import com.devglan.userportal.Services.BemService;
import com.devglan.userportal.Services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

import static com.devglan.userportal.Enums.Situacao.BAIXADO;
import static com.devglan.userportal.Enums.Situacao.INCORPORADO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/bens"})
public class BemController {
    @Autowired
    private BemService bemService;
    @Autowired
    private SalaService salaService;
    private String sala;
    private String gm;

    @PostMapping
    public Bem create(@RequestBody Bem bem){
        if(bem.getSala() == null) {
            bem.setSala(salaService.findById(17));
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

    @PutMapping(path = {"/baixar/{id}"})
    public Bem baixar(@PathVariable("id") int id, @RequestBody Bem bem){
        bem.setId(id);
        bem.setSituacao(BAIXADO);
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

    @GetMapping(path = {"/inventario"})
    public List<Bem> findInventario() throws ParseException { return bemService.findInventario(); }

    @GetMapping(path = {"/relat/{sala}"})
    public List<Bem> findAllBySalaGm(@PathVariable("sala") String sala) { return bemService.findAllBySalaGm(sala);}

}
