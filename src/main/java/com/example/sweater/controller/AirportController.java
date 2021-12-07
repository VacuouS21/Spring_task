package com.example.sweater.controller;


import com.example.sweater.Models.AirportUpdateRM;
import com.example.sweater.entity.Airport;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.repos.AirportRep;
import com.example.sweater.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    AirportService airportService;

    @Autowired
    AirportRep airportRep;

    @PostMapping("/airport")
    public Airport createAirport(@RequestBody Airport airport){
        airport.setTickets_informationListWhere(null);
        airport.setTickets_informationListFrom(null);
        return airportService.save(airport);
    }

    @GetMapping("/airport")
    List getAirports(@RequestParam(required = false) Object expand){
        return airportService.getAirports();
    }

    @GetMapping("/airport/{id}")
    Object getTicketsFromId(@PathVariable Long id){
        return airportService.getAirportFromId(id);
    }

    @PutMapping("/airport/{id}")
    public Airport updateAirport(@PathVariable Long id, @Valid @RequestBody AirportUpdateRM airportUpdateRM){
        Airport airport=airportService.update(id,airportUpdateRM);
        return airport;
    }

    @DeleteMapping("/airport/{id}")
    public Airport deleteAirport(@PathVariable Long id, @RequestParam(required = false) Object expand){
        return airportService.delete(id);
    }
}
