package com.devglan.userportal.Controllers;

import com.devglan.userportal.Models.User;
import com.devglan.userportal.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/login"})
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public User checkUser(@RequestBody User user){
        return loginService.check(user);
    }
}
