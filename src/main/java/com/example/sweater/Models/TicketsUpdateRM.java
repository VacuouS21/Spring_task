package com.example.sweater.Models;

import lombok.Data;

import java.util.Date;

@Data
public class TicketsUpdateRM {
    Long airplane;
    Date data_flight;
    Integer seat_number;
    Long from_air;
    Long where_air;
    Integer price;
}
