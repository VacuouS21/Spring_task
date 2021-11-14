package com.example.sweater.entity;

import lombok.Data;

import javax.persistence.*;



    @Entity
    @Data
    @Table(name="airplane_info", schema="public")
    public class Airplane_info {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="name_airplane")
        private String name_airplane;

        @Column(name="seats_count")
        private Integer seats_count;
}
