package com.example.sweater.repos;

import com.example.sweater.entity.Tickets_information;
import com.example.sweater.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRep extends JpaRepository<Tickets_information,Long> {
}
