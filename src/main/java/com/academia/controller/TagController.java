package com.academia.controller;

import com.academia.model.Tag;
import com.academia.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> findAll() {
        return tagService.findAll();
    }

    @GetMapping
    public Tag getById(@PathVariable Long id) {
        return tagService.findById(id);
    }

    @PostMapping
    public Tag create(@Valid @RequestBody Tag tag) {
        return tagService.create(tag);
    }

    @DeleteMapping("{tagId}")
    public void delete(@PathVariable Long tagId) {
        tagService.delete(tagId);
    }
}
