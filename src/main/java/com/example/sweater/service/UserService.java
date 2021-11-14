package com.example.sweater.service;

import com.example.sweater.Models.UserUpdateRequesModel;
import com.example.sweater.entity.User;
import com.example.sweater.repos.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public User update(Long id, UserUpdateRequesModel userUpdateRequesModel) {
    User user=userRep.findById(id).orElseThrow(EntityNotFoundException::new);
    user.setTickets(userUpdateRequesModel.getTickets());
    user.setFio(userUpdateRequesModel.getFio());
    user.setUser_login(userUpdateRequesModel.getUser_login());
    user.setUser_password(userUpdateRequesModel.getUser_password());
    userRep.save(user);
    return user;
    }
}
