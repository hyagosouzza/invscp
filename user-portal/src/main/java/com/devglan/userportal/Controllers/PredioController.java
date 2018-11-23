package com.devglan.userportal.Controllers;

import com.devglan.userportal.Models.Predio;
import com.devglan.userportal.Services.PredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/predios"})
public class PredioController {
    @Autowired
    private PredioService predioService;

    @PostMapping
    public Predio create(@RequestBody Predio predio){
        return predioService.create(predio);
    }

    @GetMapping(path = {"/{id}"})
    public Predio findOne(@PathVariable("id") int id){
        return predioService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Predio update(@PathVariable("id") int id, @RequestBody Predio predio){
        predio.setId(id);
        return predioService.update(predio);
    }

    @DeleteMapping(path ={"/{id}"})
    public Predio delete(@PathVariable("id") int id) {
        return predioService.delete(id);
    }

    @GetMapping
    public List<Predio> findAll(){
        return predioService.findAll();
    }
}
