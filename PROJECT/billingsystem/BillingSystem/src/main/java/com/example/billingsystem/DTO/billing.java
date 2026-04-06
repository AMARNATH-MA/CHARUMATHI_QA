package com.example.billingsystem.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingid;
    @Column(name = "billername")
    private String billername;
    @Column(name = "totalPrice")
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "productid")
    private product productid;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User userid;


    @ManyToOne
    @JoinColumn(name = "quantity")
    private product quantity;

}
