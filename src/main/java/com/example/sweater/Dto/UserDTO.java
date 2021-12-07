package com.example.sweater.Dto;

import com.example.sweater.entity.Tickets_information;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data

public class UserDTO {

    private Long id;

    private Long tickets;

    private String fio;

    private String user_login;

    private String user_password;

    @JsonIgnore
    private Tickets_information tickets_information;

}
