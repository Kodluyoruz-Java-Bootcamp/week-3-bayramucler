package org.kodluyoruz.medium.controller;

import org.kodluyoruz.medium.model.Tag;
import org.kodluyoruz.medium.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tags")
public class TagController {
    @Autowired
    private TagService service;

    @GetMapping
    public List<Tag> getAll() {
        return service.getAllTags();
    }

    @PostMapping
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        service.createTag(tag);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }

}
