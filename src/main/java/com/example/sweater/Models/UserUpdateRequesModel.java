package com.example.sweater.Models;

import lombok.Data;

@Data
public class UserUpdateRequesModel {

    Long tickets;
    String fio;
    String user_login;
    String user_password;
}
