package com.example.sweater.Dto;

import com.example.sweater.entity.Tickets_information;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(exclude = "tickets_information")
/*@Entity
@Table(name="users", schema="public")*/
public class UserDTO {

    private Long id;

    private Long tickets;

    private String fio;

    private String user_login;

    private String user_password;

    @JsonIgnore
    private Tickets_information tickets_information;

}
