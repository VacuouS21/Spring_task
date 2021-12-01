package com.example.sweater.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="airport", schema="public")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="city")
    private String city;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airport")
    @JsonBackReference
    private List<Tickets_information> tickets_informationList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airportWhere")
    @JsonBackReference
    private List<Tickets_information> tickets_informationList2;

}