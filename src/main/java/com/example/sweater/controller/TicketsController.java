package com.example.sweater.controller;

import com.example.sweater.Models.TicketsUpdateRM;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.repos.TicketsRep;
import com.example.sweater.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketsController {

    @Autowired
    TicketsService ticketsService;

    @Autowired
    TicketsRep ticketsRep;

    @PostMapping("/tickets")
    public void createTickets(@RequestBody Tickets_information tickets_information){ticketsService.save(tickets_information);
    }

    @GetMapping("/tickets")
    List<Tickets_information> getTickets(){
        return ticketsService.getTickets();
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
