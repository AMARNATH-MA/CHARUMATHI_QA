
package com.example.billingsystem.Controller;



import com.example.billingsystem.DTO.User;
import com.example.billingsystem.Service.Userservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")

public class Usercontroller {

    private Userservice service;

    public Usercontroller(Userservice service) {
        this.service = service;
    }

    @GetMapping("/api")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/postuser")
    public User addUser(@RequestBody User u) {
        return (User) service.saved(u);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User u) {
        return service.updateUser(id, u);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
