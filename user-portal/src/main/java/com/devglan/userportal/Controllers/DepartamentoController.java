package com.devglan.userportal.Controllers;

import com.devglan.userportal.Models.Departamento;
import com.devglan.userportal.Services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/departamentos"})
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public Departamento create(@RequestBody Departamento departamento){
        return departamentoService.create(departamento);
    }

    @GetMapping(path = {"/{id}"})
    public Departamento findOne(@PathVariable("id") int id){
        return departamentoService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Departamento update(@PathVariable("id") int id, @RequestBody Departamento departamento){
        departamento.setId(id);
        return departamentoService.update(departamento);
    }

    @DeleteMapping(path ={"/{id}"})
    public Departamento delete(@PathVariable("id") int id) {
        return departamentoService.delete(id);
    }

    @GetMapping
    public List<Departamento> findAll(){
        return departamentoService.findAll();
    }
}
