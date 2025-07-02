package com.example;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong(0);

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        user.setId(idCounter.getAndIncrement());
        users.add(user);
        return user;
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User updatedUser) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                return user;
            }
        }
        throw new RuntimeException("User not found with id: " + id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return "User with id " + id + " deleted.";
            }
        }
        throw new RuntimeException("User not found with id: " + id);
    }


    @GetMapping("/")
    public List<User> getAllUsers() {
        return users;
    }
}