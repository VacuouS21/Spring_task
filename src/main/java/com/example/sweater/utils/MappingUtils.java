package com.example.sweater.utils;


import com.example.sweater.Dto.Airplane_infoDTO;
import com.example.sweater.Dto.AirportDTO;
import com.example.sweater.Dto.TicketsDTO;
import com.example.sweater.Dto.UserDTO;
import com.example.sweater.entity.Airplane_info;
import com.example.sweater.entity.Airport;
import com.example.sweater.entity.Tickets_information;
import com.example.sweater.entity.User;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    //из entity в dto
    public UserDTO mapToProductDto(User entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setTickets(entity.getTickets().getId());
        dto.setFio(entity.getFio());
        dto.setUser_login(entity.getUser_login());
        dto.setUser_password(entity.getUser_password());
        dto.setTickets_information(entity.getTickets());
        return dto;
    }
    //из dto в entity
    public User mapToProductEntity(UserDTO dto){
        User entity = new User();
        entity.setId(dto.getId());
        entity.setTickets(dto.getTickets_information());
        entity.setFio(dto.getFio());
        entity.setUser_login(dto.getUser_login());
        entity.setUser_password(dto.getUser_password());
        return entity;
    }


    public Tickets_information mapToTicketsEntity(TicketsDTO dto){
        Tickets_information entity=new Tickets_information();
        entity.setId(dto.getId());
        entity.setAirplane(dto.getAirplaneA());
        entity.setData_flight(dto.getData_flight());
        entity.setSeat_number(dto.getSeat_number());
        entity.setAirportFrom(dto.getAirportFromA());
        entity.setAirportWhere(dto.getAirportWhereA());
        entity.setPrice(dto.getPrice());
        entity.setUsers(dto.getUsers());
        return entity;
    }


    public TicketsDTO mapToTicketsDto(Tickets_information entity){
        TicketsDTO dto=new TicketsDTO();
        dto.setId(entity.getId());
        dto.setSeat_number(entity.getSeat_number());
        dto.setAirplane(entity.getAirplane().getId());
        dto.setData_flight(entity.getData_flight());
        dto.setAirportFrom(entity.getAirportFrom().getId());
        dto.setAirportWhere(entity.getAirportWhere().getId());
        dto.setPrice(entity.getPrice());
        dto.setAirplaneA(entity.getAirplane());
        dto.setAirportFromA(entity.getAirportFrom());
        dto.setAirportWhereA(entity.getAirportWhere());
        dto.setUsers(entity.getUsers());
        return dto;
    }


    public Airplane_info mapToAirplaneEntity(Airplane_infoDTO dto){
        Airplane_info entity=new Airplane_info();
        entity.setId(dto.getId());
        entity.setSeats_count(dto.getSeats_count());
        entity.setName_airplane(dto.getName_airplane());
        entity.setSeats_count(dto.getSeats_count());
        entity.setTickets_informationList(dto.getTickets_informationList());
        return entity;
    }


    public Airplane_infoDTO mapToAirplaneDto(Airplane_info entity){
        Airplane_infoDTO dto=new Airplane_infoDTO();
        dto.setId(entity.getId());
        dto.setName_airplane(entity.getName_airplane());
        dto.setSeats_count(entity.getSeats_count());
        dto.setTickets_informationList(entity.getTickets_informationList());
        return dto;
    }


    public Airport mapToAirportEntity(AirportDTO dto){
        Airport entity=new Airport();
        entity.setId(dto.getId());
        entity.setCity(dto.getCity());

        entity.setTickets_informationListFrom(dto.getTickets_informationListFrom());
        entity.setTickets_informationListWhere(dto.getTickets_informationListWhere());
        return entity;
    }


    public AirportDTO mapToAirportDto(Airport entity){
        AirportDTO dto=new AirportDTO();
        dto.setId(entity.getId());
        dto.setCity(entity.getCity());
        dto.setTickets_informationListFrom(entity.getTickets_informationListFrom());
        dto.setTickets_informationListWhere(entity.getTickets_informationListWhere());
        return dto;
    }
}