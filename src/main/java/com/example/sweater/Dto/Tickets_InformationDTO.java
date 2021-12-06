package com.example.sweater.Dto;

import com.example.sweater.entity.Airplane_info;
import com.example.sweater.entity.Airport;
import com.example.sweater.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class Tickets_InformationDTO {

    private Long id;

    private Long airplaneId;

    private Date data_flight;

    private Integer seat_number;

    private Long airportFromId;

    private Long airportWhereId;

    private Integer price;

    private Airplane_info airplane;

    private Airport airportFrom;

    private Airport airportWhere;


}
