package com.example.sweater.utils;

import com.example.sweater.Dto.UserDTO;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.entity.User;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    //из entity в dto
    public UserDTO mapToProductDto(User entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setTickets(entity.getTickets().getId());
        dto.setFio(entity.getFio());
        dto.setUser_login(entity.getUser_login());
        dto.setUser_password(entity.getUser_password());
        dto.setTickets_information(entity.getTickets());
        return dto;
    }
    //из dto в entity
    public User mapToProductEntity(UserDTO dto){
        Tickets_information tickets =new Tickets_information();
        User entity = new User();
        entity.setId(dto.getId());
        entity.setTickets(dto.getTickets_information());
        entity.setFio(dto.getFio());
        entity.setUser_login(dto.getUser_login());
        entity.setUser_password(dto.getUser_password());
        return entity;
    }
}