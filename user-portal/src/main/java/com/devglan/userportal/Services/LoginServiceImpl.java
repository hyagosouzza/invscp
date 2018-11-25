package com.devglan.userportal.Services;

import com.devglan.userportal.Models.User;
import com.devglan.userportal.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserRepository repository;

    @Override
    public User check(User user) {
        User userRet = null;

        List<User> users = repository.findAll();

        for(User usr : users) {
            if(usr.getEmail().equals(user.getEmail()) && usr.getSenha().equals(user.getSenha())) {
                userRet = usr;
            }
        }

        return userRet;
    }
}
