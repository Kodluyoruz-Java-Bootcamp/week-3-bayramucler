package org.kodluyoruz.medium.controller;

import org.kodluyoruz.medium.model.Blog;
import org.kodluyoruz.medium.model.User;
import org.kodluyoruz.medium.service.BlogService;
import org.kodluyoruz.medium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        service.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


}
