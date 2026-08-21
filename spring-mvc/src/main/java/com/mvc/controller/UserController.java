package com.mvc.controller;


import com.mvc.model.User;
import com.mvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 =  userService.createUser(user);
        return ResponseEntity.status(201).body(user1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> fetchUser(@PathVariable (value = "id") Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping()
    public ResponseEntity<List<User>> fetchAllUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.status(200).body(userList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable (value = "id") Integer id, @RequestBody User user) {
        User user1 = userService.updateUser(user);
        return ResponseEntity.status(200).body("User updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable (value = "id") Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        if (!isDeleted) {
            return ResponseEntity.status(404).body("USER_NOT_FOUND");
        }
        return ResponseEntity.status(200).body("User Deleted");
    }
}
