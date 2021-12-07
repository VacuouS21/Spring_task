package com.example.sweater.service;

import com.example.sweater.Models.TicketsUpdateRM;
import com.example.sweater.entity.Airplane_info;
import com.example.sweater.entity.Airport;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.repos.AirplaneRep;
import com.example.sweater.repos.AirportRep;
import com.example.sweater.repos.TicketsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

    @Service
    public class TicketsService {
        @Autowired
        TicketsRep ticketsRep;

        @Autowired
        AirplaneRep airplaneRep;
        @Autowired
        AirportRep airportRep;

        public Tickets_information save(Tickets_information tickets_information){
           return ticketsRep.save(tickets_information);
        }
        public List<Tickets_information> getTickets(){
            return ticketsRep.findAll();
        }

        public Tickets_information getTicketFromId(Long id){
            return ticketsRep.findById(id).orElse(null);
        }

        public Tickets_information update(Long id, TicketsUpdateRM ticketsUpdateRM) {
            //System.out.println(id);
            Tickets_information ticket=ticketsRep.findById(id).orElseThrow(EntityNotFoundException::new);

            ticket.setPrice(ticketsUpdateRM.getPrice());
           ticket.setSeat_number(ticketsUpdateRM.getSeat_number());
            ticket.setData_flight(ticketsUpdateRM.getData_flight());
            Airplane_info airplane=airplaneRep.findById(ticketsUpdateRM.getAirplane()).orElseThrow(EntityNotFoundException::new);
            Airport airFrom=airportRep.findById(ticketsUpdateRM.getAirportFrom()).orElseThrow(EntityNotFoundException::new);
            Airport airWhere=airportRep.findById(ticketsUpdateRM.getAirportWhere()).orElseThrow(EntityNotFoundException::new);
            ticket.updateAirplane(airplane);
            ticket.updateAirportFrom(airFrom);
            ticket.updateAirportWhere(airWhere);

            return ticketsRep.save(ticket);

        }

       public Tickets_information getTicketsFromId(Long id){
            return ticketsRep.findById(id).orElse(null);
        }

        public void delete(Long id) {
            ticketsRep.deleteById(id);
        }
    }