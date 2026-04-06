package com.example.billingsystem.Repository;

import com.example.billingsystem.DTO.billing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface billingrepository extends JpaRepository<billing, Long> {
}