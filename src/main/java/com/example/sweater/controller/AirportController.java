package com.example.sweater.controller;


import com.example.sweater.Models.AirportUpdateRM;
import com.example.sweater.entity.Airport;
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

    @PostMapping("/airport/new")
    public void createAirport(@RequestBody Airport airport){
        airportService.save(airport);
    }

    @GetMapping("/airport/view")
    List<Airport> getAirports(){
        return airportService.getAirports();
    }

    @PutMapping("/airport/up/{id}")
    public Airport updateAirport(@PathVariable Long id, @Valid @RequestBody AirportUpdateRM airportUpdateRM){
        Airport airport=airportService.update(id,airportUpdateRM);
        return airport;
    }

    @DeleteMapping("/airport/delete/{id}")
    public void deleteAirport(@PathVariable Long id){
        airportService.delete(id);
    }
}
