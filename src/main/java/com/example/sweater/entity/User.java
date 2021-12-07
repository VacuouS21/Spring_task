package com.example.sweater.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "tickets")
    private Tickets_information tickets;

    @Column(name="fio")
    private String fio;

    @Column(name="user_login")
    private String user_login;

    @Column(name="user_password")
    private String user_password;

    public void updateTickets(Tickets_information ticket) {
        tickets.getUsers().remove(this);
        ticket.getUsers().add(this);
        this.tickets=ticket;

    }


}
