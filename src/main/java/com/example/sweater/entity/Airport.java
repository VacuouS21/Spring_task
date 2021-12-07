package com.example.sweater.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="airport", schema="public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="city")
    private String city;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airportFrom",cascade = CascadeType.ALL)
    private List<Tickets_information> tickets_informationListFrom;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airportWhere",cascade = CascadeType.ALL)
    private List<Tickets_information> tickets_informationListWhere;

}