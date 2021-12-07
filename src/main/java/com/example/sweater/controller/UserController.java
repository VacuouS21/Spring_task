package com.example.sweater.controller;

import com.example.sweater.Dto.UserDTO;
import com.example.sweater.Models.filters.UserPage;
import com.example.sweater.Models.filters.UserSearchCriteria;
import com.example.sweater.Models.UserUpdateRequesModel;
import com.example.sweater.entity.User;
import com.example.sweater.repos.UserRep;
import com.example.sweater.service.TicketsService;
import com.example.sweater.service.UserService;
import com.example.sweater.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRep userRep;

    @Autowired
    MappingUtils mappingUtils;

    @Autowired
    TicketsService ticketsService;

    @PostMapping("/user")
    public User createUser(@RequestBody UserDTO userDTO) {
        User user= new User();
        user.setTickets(ticketsService.getTicketsFromId(userDTO.getTickets()));
        user.setFio(userDTO.getFio());
        user.setUser_login(userDTO.getUser_login());
        user.setUser_password(userDTO.getUser_password());
       // return null;
        userService.save(user);
        return user;
    }

    @GetMapping("/user")
    public List getUsers(UserPage userPage, UserSearchCriteria userSearchCriteria, @RequestParam(required = false) Object expand) {
        List<User> entitiesS = userService.getUsers(userPage, userSearchCriteria);
        if (expand != null) {
            return entitiesS;
        }
        return entitiesS.stream() //создали из листа стирим
                .map(mappingUtils::mapToProductDto) //оператором из streamAPI map, использовали для каждого элемента метод mapToProductDto из класса MappingUtils
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    Object getUserFromId(@PathVariable Long id, @RequestParam(required = false) Object expand) {
        User entitiesS = userService.getUserFromId(id);
        if (expand != null) {
            return entitiesS;
        }
        return mappingUtils.mapToProductDto(entitiesS);//в метод mapToProductDto
        //поместили результат поиска по id
        //.orElse(new ProductEntity()) //если ни чего не нашли, то вернем пустой entity

    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequesModel userUpdateRequesModel) {
        User user = userService.update(id, userUpdateRequesModel);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable Long id) {

        User user = userService.delete(id);
        return user;
    }
}
