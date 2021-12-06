package com.example.sweater.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="users", schema="public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tickets",updatable = false,nullable = false)
    private Tickets_information tickets;

    @Column(name="fio")
    private String fio;

    @Column(name="user_login")
    private String user_login;

    @Column(name="user_password")
    private String user_password;

}
