package com.example.billingsystem.Service;

import com.example.billingsystem.DTO.product;
import com.example.billingsystem.Repository.productrepository;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productservice {

    private productrepository repo;

    public productservice(productrepository repo) {
        this.repo = repo;
    }

    public List<product> getproduct() {
        return repo.findAll();
    }

    public product addProduct(product p) {
        p.setProductid(0);
        return repo.save(p);
    }

    public product updateall(int id, product p) {
        return repo.findById((long) id).map(existing -> {
            existing.setProductname(p.getProductname());
            existing.setProductid(p.getProductid());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public String deleteall(int id) {
        repo.deleteById((long) id);
        return "Deleted successfully";
    }
}