package com.example.sweater.service;

import com.example.sweater.Models.UserCriteriaRep;
import com.example.sweater.Models.UserPage;
import com.example.sweater.Models.UserSearchCriteria;
import com.example.sweater.Models.UserUpdateRequesModel;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.entity.User;
import com.example.sweater.repos.TicketsRep;
import com.example.sweater.repos.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRep userRep;

    @Autowired
    TicketsRep ticketsRep;

    @Autowired
    private UserCriteriaRep userCriteriaRep;

    public User save(User user){
       User newUser= userRep.save(user);
       return newUser;
    }
/*    public List<User> getUsers(){

        return userRep.findAll();
    }*/

    public User update(Long id, UserUpdateRequesModel userUpdateRequesModel) {

    User user=userRep.findById(id).orElseThrow(EntityNotFoundException::new);
    //user.setTickets(userUpdateRequesModel.getTickets());
    user.setFio(userUpdateRequesModel.getFio());
    user.setUser_login(userUpdateRequesModel.getUser_login());
    user.setUser_password(userUpdateRequesModel.getUser_password());
    userRep.save(user);
    return user;
    }

    public User getUserFromId(Long id){
        return userRep.findById(id).orElse(null);
    }
    public User delete(Long id) {
        User user=userRep.findById(id).orElse(null);
        if(user!=null)  userRep.deleteById(id);
        return user;

    }

    public List<User> getUsers(UserPage userPage, UserSearchCriteria userSearchCriteria){
        return userCriteriaRep.FindAllWithFilters(userPage,userSearchCriteria);
    }

    public Tickets_information getTicket(Long id){
        User user= userRep.findById(id).orElse(null);
        //return ticketsRep.findById(user.getTickets()).orElse(null);
        return ticketsRep.findById(id).orElse(null);
    }
}
