package com.example.billingsystem.Repository;

import com.example.billingsystem.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}