package com.academia.repository;

import com.academia.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
