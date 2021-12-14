package com.academia.service;

import com.academia.exception.ResourceNotFoundException;
import com.academia.model.Tag;
import com.academia.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagService {


    private final TagRepository tagRepository;


    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }


    @Transactional(readOnly = true)
    public Tag findById(Long id) {
        return tagRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found - " + id));
    }

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Transactional
    public Tag create(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    public void delete(Long id) {
        tagRepository.deleteById(id);
    }

}


