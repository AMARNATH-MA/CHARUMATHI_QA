package com.example.billingsystem.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;
    @Column(name = "productname")
    private String productname;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
}
