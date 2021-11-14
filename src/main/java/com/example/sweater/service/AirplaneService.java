package com.example.sweater.service;

import com.example.sweater.Models.AirplaneUpdateRM;
import com.example.sweater.entity.Airplane_info;
import com.example.sweater.repos.AirplaneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AirplaneService {
    @Autowired
    AirplaneRep airplaneRep;

    public void save(Airplane_info airplane_info){
        airplaneRep.save(airplane_info);
    }
    public List<Airplane_info> getairplane_infos(){
        return airplaneRep.findAll();
    }

    public Airplane_info update(Long id, AirplaneUpdateRM airplaneUpdateRM) {

        Airplane_info airplane_info=airplaneRep.findById(id).orElseThrow(EntityNotFoundException::new);
        airplane_info.setName_airplane(airplaneUpdateRM.getName_airplane());
        airplane_info.setSeats_count(airplaneUpdateRM.getSeats_count());
        airplaneRep.save(airplane_info);
        return airplane_info;
    }

    public void delete(Long id) {
        airplaneRep.deleteById(id);
    }
}