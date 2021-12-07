package com.example.sweater.Dto;

import com.example.sweater.entity.Tickets_information;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class Airplane_infoDTO {
    private Long id;

    private String name_airplane;

    private Integer seats_count;

    @JsonIgnore
    private List<Tickets_information> tickets_informationList;
}
