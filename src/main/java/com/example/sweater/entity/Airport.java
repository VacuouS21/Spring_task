package com.example.sweater.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="airport", schema="public")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="city")
    private String city;

}