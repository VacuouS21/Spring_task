package com.example.sweater.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airplane")
    @JsonBackReference
    private List<Tickets_information> tickets_informationList;
}
