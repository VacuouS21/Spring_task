package com.example.sweater.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


    @Entity
    @Data
    @ToString(exclude = "users")
    @Table(name="tickets_Information", schema="public")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public class Tickets_information {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "airplane",updatable = false,nullable = false)
        private Airplane_info airplane;

        @Column(name="data_flight")
        private Date data_flight;

        @Column(name = "seat_number")
        private Integer seat_number;


        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "from_air",updatable = false,nullable = false)
        private Airport airportFrom;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "where_air",updatable = false,nullable = false)
        private Airport airportWhere;

        @Column(name="price")
        private Integer price;


        @OneToMany(fetch = FetchType.EAGER, mappedBy = "tickets")
        @JsonBackReference
        private List<User> users;



    }