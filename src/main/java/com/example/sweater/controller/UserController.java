package com.example.sweater.controller;

import com.example.sweater.Models.UserPage;
import com.example.sweater.Models.UserSearchCriteria;
import com.example.sweater.Models.UserUpdateRequesModel;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.entity.User;
import com.example.sweater.repos.UserRep;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/user")
    public List<User> getUsers(UserPage userPage,UserSearchCriteria userSearchCriteria){
        return userService.getUsers(userPage,userSearchCriteria);
    }

    @GetMapping("/user/{id}")
    User getUserFromId(@PathVariable Long id){
        return userService.getUserFromId(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequesModel userUpdateRequesModel){
        User user=userService.update(id,userUpdateRequesModel);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable Long id){

        User user=userService.delete(id);
        return user;
    }


}
