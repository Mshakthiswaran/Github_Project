package com.tnsif.customeruser1.usercontroller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.customeruser1.service.UserService;
import com.tnsif.customeruser1.user.User;

@RestController
@RequestMapping("/userservice") // ✅ Centralized base path for consistency
public class UserController {

    @Autowired
    private UserService service;

    // ✅ GET all users
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // ✅ GET user by ID with proper exception handling
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        try {
            User user = service.getById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ POST new user
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User savedUser = service.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // ✅ PUT update user with field-by-field update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        try {
            User existingUser = service.getById(id); // ✅ Correct import and method
            if (updatedUser != null) {
                existingUser.setUsername(updatedUser.getUsername());
                existingUser.setPassword(updatedUser.getPassword()); // ✅ Renamed from setPass()
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setRole(updatedUser.getRole());
                existingUser.setAddress(updatedUser.getAddress());

                User savedUser = service.updateUser(existingUser);
                return new ResponseEntity<>(savedUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // ✅ Null check
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // ✅ Correct exception type
        }
    }

    // ✅ DELETE user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}