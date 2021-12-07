package com.example.sweater.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
    @Data
    @Table(name="airplane_info", schema="public")
   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public class Airplane_info {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="name_airplane")
        private String name_airplane;

        @Column(name="seats_count")
        private Integer seats_count;

        @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airplane",cascade = CascadeType.ALL)
    private List<Tickets_information> tickets_informationList;
}
