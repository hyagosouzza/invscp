package com.devglan.userportal.Controllers;

import com.devglan.userportal.Models.Local;
import com.devglan.userportal.Services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/locais"})
public class LocalController {
    @Autowired
    private LocalService localService;

    @PostMapping
    public Local create(@RequestBody Local local){
        return localService.create(local);
    }

    @GetMapping(path = {"/{id}"})
    public Local findOne(@PathVariable("id") int id){
        return localService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Local update(@PathVariable("id") int id, @RequestBody Local local){
        local.setId(id);
        return localService.update(local);
    }

    @DeleteMapping(path ={"/{id}"})
    public Local delete(@PathVariable("id") int id) {
        return localService.delete(id);
    }

    @GetMapping
    public List<Local> findAll(){
        return localService.findAll();
    }
}
