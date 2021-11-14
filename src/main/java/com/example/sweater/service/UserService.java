package com.example.sweater.service;

import com.example.sweater.entity.User;
import com.example.sweater.repos.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRep userRep;

    public void save(User user){
        userRep.save(user);
    }
    public List<User> getUsers(){
        return userRep.findAll();
    }
}
