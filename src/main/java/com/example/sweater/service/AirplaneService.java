package com.example.sweater.service;

import com.example.sweater.Models.AirplaneUpdateRM;
import com.example.sweater.entity.Airplane_info;
import com.example.sweater.entity.Airport;
import com.example.sweater.repos.AirplaneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AirplaneService {
    @Autowired
    AirplaneRep airplaneRep;

    public Airplane_info save(Airplane_info airplane_info){
        return airplaneRep.save(airplane_info);
    }
    public List<Airplane_info> getairplane_infos(){
        return airplaneRep.findAll();
    }

    public Airplane_info getAirplaneFromId(Long id){
        return airplaneRep.findById(id).orElse(null);
    }

    public Airplane_info update(Long id, AirplaneUpdateRM airplaneUpdateRM) {

        Airplane_info airplane_info=airplaneRep.findById(id).orElseThrow(EntityNotFoundException::new);
        airplane_info.setName_airplane(airplaneUpdateRM.getName_airplane());
        airplane_info.setSeats_count(airplaneUpdateRM.getSeats_count());
        airplaneRep.save(airplane_info);
        return airplane_info;
    }

    public Airplane_info delete(Long id) {
        Airplane_info airplane_info=airplaneRep.findById(id).orElse(null);;
        if(airplaneRep!=null) airplaneRep.deleteById(id);
        return airplane_info;
    }
}