package com.example.sweater.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
    @Data
    @Table(name="tickets_Information", schema="public")
    public class Tickets_information {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="airplane")
        private Long airplane;

        @Column(name="data_flight")
        private Date data_flight;

        @Column(name = "seat_number")
        private Integer seat_number;

        @Column(name="from_air")
    private Long from_air;

        @Column(name = "where_air")
    private Long where_air;

        @Column(name="price")
        private Integer price;
    }