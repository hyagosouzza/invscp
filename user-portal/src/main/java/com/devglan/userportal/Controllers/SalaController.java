package com.devglan.userportal.Controllers;

import com.devglan.userportal.Models.Sala;
import com.devglan.userportal.Services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/salas"})
public class SalaController {
    @Autowired
    private SalaService salaService;

    @PostMapping
    public Sala create(@RequestBody Sala sala){
        return salaService.create(sala);
    }

    @GetMapping(path = {"/{id}"})
    public Sala findOne(@PathVariable("id") int id){
        return salaService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Sala update(@PathVariable("id") int id, @RequestBody Sala sala){
        sala.setId(id);
        return salaService.update(sala);
    }

    @DeleteMapping(path ={"/{id}"})
    public Sala delete(@PathVariable("id") int id) {
        return salaService.delete(id);
    }

    @GetMapping
    public List<Sala> findAll(){
        return salaService.findAll();
    }
}
