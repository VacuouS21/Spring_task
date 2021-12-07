package com.example.sweater.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


    @Entity
    @Getter
    @Setter
    @ToString(exclude = "users")
    @Table(name="tickets_Information", schema="public")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public class Tickets_information {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
        @JoinColumn(name = "airplane")
        private Airplane_info airplane;

        @Column(name="data_flight")
        private Date data_flight;

        @Column(name = "seat_number")
        private Integer seat_number;


        @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
        @JoinColumn(name = "from_air")
        private Airport airportFrom;

        @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
        @JoinColumn(name = "where_air")
        private Airport airportWhere;

        @Column(name="price")
        private Integer price;

        @JsonIgnore
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "tickets",cascade = CascadeType.ALL)
        private List<User> users;

        public void updateAirplane(Airplane_info airplanes) {
            airplane.getTickets_informationList().remove(this);
            airplanes.getTickets_informationList().add(this);
            this.airplane=airplanes;
        }
        public void updateAirportFrom(Airport airport) {
            airportFrom.getTickets_informationListFrom().remove(this);
            airport.getTickets_informationListFrom().add(this);
            this.airportFrom=airport;
        }
        public void updateAirportWhere(Airport airport) {
            airportWhere.getTickets_informationListFrom().remove(this);
            airport.getTickets_informationListFrom().add(this);
            this.airportWhere=airport;
        }



    }