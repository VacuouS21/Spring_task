package com.example.sweater.service;

import com.example.sweater.Models.AirportUpdateRM;
import com.example.sweater.entity.Airport;
import com.example.sweater.repos.AirportRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AirportService {
    @Autowired
    AirportRep airportRep;

    public void save(Airport airport){
        airportRep.save(airport);
    }
    public List<Airport> getAirports(){
        return airportRep.findAll();
    }

    public Airport update(Long id, AirportUpdateRM airportUpdateRM) {

        Airport airport =airportRep.findById(id).orElseThrow(EntityNotFoundException::new);
        airport.setCity(airportUpdateRM.getCity());

        airportRep.save(airport);
        return airport;
    }

    public void delete(Long id) {
        airportRep.deleteById(id);
    }
}
