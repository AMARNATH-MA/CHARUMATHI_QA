package com.example.billingsystem.Service;

import com.example.billingsystem.DTO.User;
import com.example.billingsystem.Repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {

    private UserRepo repo;

    public Userservice(UserRepo repo) {
        this.repo = repo;
    }

    // GET ALL
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // CREATE
    public User saved(User u) {
        return repo.save(u);
    }

    // UPDATE
    public User updateUser(int userid, User u) {
        User existing = repo.findById(userid)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        existing.setName(u.getName());

        return repo.save(existing);
    }

    // DELETE
    public String deleteUser(int id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }
        repo.deleteById(id);
        return "Deleted successfully";
    }
}