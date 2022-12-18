package org.kodluyoruz.medium.controller;

import org.kodluyoruz.medium.model.Blog;
import org.kodluyoruz.medium.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/blogs")
public class BlogController {
    @Autowired
    private BlogService service;

    @GetMapping
    public List<Blog> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        service.createBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Blog> delete(@RequestBody Blog blog) {
        service.removeBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }


}
