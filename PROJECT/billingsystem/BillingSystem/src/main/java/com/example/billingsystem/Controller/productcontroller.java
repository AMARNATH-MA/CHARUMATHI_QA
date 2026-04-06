package com.example.billingsystem.Controller;

import com.example.billingsystem.DTO.product;

import com.example.billingsystem.Service.productservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class productcontroller {

    private productservice pro;

    public productcontroller(productservice pro) {
        this.pro = pro;
    }

    @GetMapping("/getproduct")
    public List<product> getproduct() {
        return pro.getproduct();
    }

    @PostMapping("/postproduct")
    public product addProduct(@RequestBody product b) {
        return pro.addProduct(b);
    }

    @PutMapping("/{id}")
    public product updateProduct(@PathVariable int id, @RequestBody product b) {
        return pro.updateall(id, b);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return pro.deleteall(id);
    }
}