package com.example.sweater.service;

import com.example.sweater.Models.filters.UserCriteriaRep;
import com.example.sweater.Models.filters.UserPage;
import com.example.sweater.Models.filters.UserSearchCriteria;
import com.example.sweater.Models.UserUpdateRequesModel;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.entity.User;
import com.example.sweater.repos.TicketsRep;
import com.example.sweater.repos.UserRep;
import com.example.sweater.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRep userRep;

    @Autowired
    TicketsRep ticketsRep;

    @Autowired
    private UserCriteriaRep userCriteriaRep;

    @Autowired
    MappingUtils mappingUtils;

    public User save(User user){
       User newUser= userRep.save(user);
       return newUser;
    }
    public User update(Long id, UserUpdateRequesModel userUpdateRequesModel) {

    User user= userRep.findById(id).orElseThrow(EntityNotFoundException::new);
    Tickets_information tickets_information=ticketsRep.findById(userUpdateRequesModel.getTickets()).orElseThrow(EntityNotFoundException::new) ;
    user.updateTickets(tickets_information);
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


}
