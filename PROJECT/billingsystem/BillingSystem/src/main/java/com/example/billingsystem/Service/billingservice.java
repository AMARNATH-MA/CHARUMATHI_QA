package com.example.billingsystem.Service;

import com.example.billingsystem.DTO.User;
import com.example.billingsystem.DTO.billing;
import com.example.billingsystem.DTO.product;
import com.example.billingsystem.Repository.UserRepo;
import com.example.billingsystem.Repository.billingrepository;

import com.example.billingsystem.Repository.productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class billingservice {
@Autowired
    private billingrepository repo;

    public billingservice(billingrepository repo) {
        this.repo = repo;
    }

    public List<billing> getAllBilling() {
        return repo.findAll();
    }

    @Autowired
    private productrepository productRepo;

    @Autowired
    private UserRepo userRepo;
    public billing addBilling(billing b) {

        int productId =b.getProductid().getProductid();
        int userId = b.getUserid().getUserId();

        product p = productRepo.findById((long) productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User u = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));


        if (p.getQuantity() < b.getQuantity().getQuantity()) {
            throw new RuntimeException("Not enough stock available");
        }


        double total = p.getPrice() * b.getQuantity().getQuantity();


        p.setQuantity(p.getQuantity() - b.getQuantity().getQuantity());
        productRepo.save(p);


        b.setTotalPrice(total);
        b.setProductid(p);
        b.setUserid(u);

        return repo.save(b);
    }
    public String deleteBilling(Long id) {
        repo.deleteById(id);
        return "Deleted successfully";
    }
}