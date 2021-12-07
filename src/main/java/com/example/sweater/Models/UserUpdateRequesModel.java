package com.example.sweater.Models;

import com.example.sweater.entity.Tickets_information;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserUpdateRequesModel {

    Long tickets;
    String fio;
    String user_login;
    String user_password;
}
