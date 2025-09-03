package com.tnsif.customeruser1.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.customeruser1.repository.UserRepository;
import com.tnsif.customeruser1.user.User;

@Service // ✅ Added to register as a Spring service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        // ✅ Replaced .get() with orElseThrow for safety
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public User updateUser(User user) {
        if (!repo.existsById(user.getId())) {
            throw new NoSuchElementException("Cannot update. User not found with id: " + user.getId());
        }
        return repo.save(user); // ✅ Added existence check
    }

    public void deleteUser(Integer id) {
        repo.deleteById(id);
    }
}