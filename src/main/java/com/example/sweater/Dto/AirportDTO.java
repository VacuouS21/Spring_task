package com.example.sweater.Dto;

import com.example.sweater.entity.Tickets_information;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class AirportDTO {
    private Long id;

    private String city;

    @JsonIgnore
    private List<Tickets_information> tickets_informationListFrom;

    @JsonIgnore
    private List<Tickets_information> tickets_informationListWhere;
}
