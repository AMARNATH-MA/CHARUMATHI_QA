package com.example.billingsystem.Repository;

import com.example.billingsystem.DTO.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productrepository extends JpaRepository<product, Long> {
}