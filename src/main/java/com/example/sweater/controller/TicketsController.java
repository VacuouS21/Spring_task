package com.example.sweater.controller;

import com.example.sweater.Models.TicketsUpdateRM;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.entity.User;
import com.example.sweater.repos.AirplaneRep;
import com.example.sweater.repos.AirportRep;
import com.example.sweater.repos.TicketsRep;
import com.example.sweater.service.AirplaneService;
import com.example.sweater.service.AirportService;
import com.example.sweater.service.TicketsService;
import com.example.sweater.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sweater.Dto.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TicketsController {

    @Autowired
    TicketsService ticketsService;

    @Autowired
    TicketsRep ticketsRep;

    @Autowired
    MappingUtils mappingUtils;

    @Autowired
    AirplaneService airplaneService;

    @Autowired
    AirportService airportService;
    @PostMapping("/tickets")
    public Tickets_information createTickets(@RequestBody TicketsDTO ticketsDTO){
        Tickets_information ticket=new Tickets_information();
        ticket.setUsers(null);
        ticket.setData_flight(ticketsDTO.getData_flight());
        ticket.setPrice(ticketsDTO.getPrice());
        ticket.setSeat_number(ticketsDTO.getSeat_number());
        ticket.setAirplane(airplaneService.getAirplaneFromId(ticketsDTO.getAirplane()));
        ticket.setAirportFrom(airportService.getAirportFromId(ticketsDTO.getAirportFrom()));
        ticket.setAirportWhere(airportService.getAirportFromId(ticketsDTO.getAirportWhere()));
        ticketsService.save(ticket);
        return ticket;
    }

    @GetMapping("/tickets")
    List getTickets(@RequestParam(required = false) Object expand){
        List<Tickets_information> entitiesS = ticketsService.getTickets();
        if (expand != null) {
            return entitiesS;
        }
        return entitiesS.stream() //создали из листа стирим
                .map(mappingUtils::mapToTicketsDto) //оператором из streamAPI map, использовали для каждого элемента метод mapToProductDto из класса MappingUtils
                .collect(Collectors.toList());
    }

    @GetMapping("/tickets/{id}")
    Object getTicketsFromId(@PathVariable Long id, @RequestParam(required = false) Object expand){
        Tickets_information entitiesS = ticketsService.getTicketsFromId(id);
        if (expand != null) {
            return entitiesS;
        }
        return mappingUtils.mapToTicketsDto(entitiesS);
        //return ticketsService.getTicketFromId(id);
    }

    @PutMapping("/tickets/{id}")
    public Tickets_information updateTickets(@PathVariable Long id, @Valid @RequestBody TicketsUpdateRM ticketsUpdateRM){
        Tickets_information tickets_information=ticketsService.update(id,ticketsUpdateRM);
        return tickets_information;
    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTickets(@PathVariable Long id){
        ticketsService.delete(id);
    }
}
