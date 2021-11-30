package com.example.sweater.controller;

import com.example.sweater.Models.AirplaneUpdateRM;
import com.example.sweater.Models.UserUpdateRequesModel;
import com.example.sweater.entity.Airplane_info;
import com.example.sweater.entity.User;
import com.example.sweater.repos.AirplaneRep;
import com.example.sweater.repos.UserRep;
import com.example.sweater.service.AirplaneService;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AirplaneController {

    @Autowired
    AirplaneService airplaneService;

    @Autowired
    AirplaneRep airplaneRep;

    @PostMapping("/airplane")
    public void createAirplane(@RequestBody Airplane_info airplane_info){
        airplaneService.save(airplane_info);
    }

    @GetMapping("/airplane")
    List<Airplane_info> geteAirplanes(){
        return airplaneService.getairplane_infos();
    }

    @PutMapping("/airplane/{id}")
    public Airplane_info updateAirplane(@PathVariable Long id, @Valid @RequestBody AirplaneUpdateRM airplaneUpdateRM){
        Airplane_info airplane_info=airplaneService.update(id,airplaneUpdateRM);
        return airplane_info;
    }

    @DeleteMapping("/airplane/{id}")
    public void deleteAirplane(@PathVariable Long id){
        airplaneService.delete(id);
    }
}
