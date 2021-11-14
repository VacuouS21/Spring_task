package com.example.sweater.controller;

import com.example.sweater.Models.UserUpdateRequesModel;
import com.example.sweater.entity.User;
import com.example.sweater.repos.UserRep;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRep userRep;

    @PostMapping("/user/new")
    public void createUser(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/user/view")
    List<User> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/user/up/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequesModel userUpdateRequesModel){
        User user=userService.update(id,userUpdateRequesModel);
        return user;
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }
}
