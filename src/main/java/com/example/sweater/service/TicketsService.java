package com.example.sweater.service;

import com.example.sweater.Models.TicketsUpdateRM;
import com.example.sweater.Models.UserUpdateRequesModel;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.entity.User;
import com.example.sweater.repos.TicketsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

    @Service
    public class TicketsService {
        @Autowired
        TicketsRep ticketsRep;

        public void save(Tickets_information tickets_information){
            ticketsRep.save(tickets_information);
        }
        public List<Tickets_information> getTickets(){
            return ticketsRep.findAll();
        }

        public Tickets_information update(Long id, TicketsUpdateRM ticketsUpdateRM) {

            Tickets_information tickets_information = ticketsRep.findById(id).orElseThrow(EntityNotFoundException::new);
            tickets_information.setAirplane(ticketsUpdateRM.getAirplane());
            tickets_information.setData_flight(ticketsUpdateRM.getData_flight());
            tickets_information.setFrom_air(ticketsUpdateRM.getFrom_air());
            tickets_information.setWhere_air(ticketsUpdateRM.getWhere_air());
            tickets_information.setSeat_number(ticketsUpdateRM.getSeat_number());
            tickets_information.setPrice(ticketsUpdateRM.getPrice());
            ticketsRep.save(tickets_information);
            return tickets_information;
        }

        public void delete(Long id) {
            ticketsRep.deleteById(id);
        }
    }