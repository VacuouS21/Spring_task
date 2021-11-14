package com.example.sweater.repos;

import com.example.sweater.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User,Long> {
}
