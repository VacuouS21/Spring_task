package com.example.sweater.repos;

import com.example.sweater.entity.Airplane_info;
import com.example.sweater.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRep extends JpaRepository<Airplane_info,Long> {
}
