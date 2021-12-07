package com.example.sweater.Dto;

import com.example.sweater.entity.Airplane_info;
import com.example.sweater.entity.Airport;
import com.example.sweater.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class TicketsDTO {

    private Long id;

    private Long airplane;

    private Date data_flight;

    private Integer seat_number;

    private Long airportFrom;

    private Long airportWhere;

    private Integer price;

    @JsonIgnore
    private Airplane_info airplaneA;
    @JsonIgnore
    private Airport airportFromA;
    @JsonIgnore
    private Airport airportWhereA;
    @JsonIgnore
    private List<User> users;


}
