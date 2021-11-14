package com.example.sweater.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="User", schema="public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tickets")
    private Long tickets;

    @Column(name="fio")
    private String fio;

    @Column(name="user_login")
    private String user_login;

    @Column(name="user_password")
    private String user_password;
}
