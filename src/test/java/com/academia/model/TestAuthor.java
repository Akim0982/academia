package com.academia.model;

import com.academia.repository.AuthorRepository;
import com.academia.service.AuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.com.github.dockerjava.core.MediaType;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class TestAuthor {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AuthorRepository authorRepository;
    @MockBean
    private ObjectMapper objectMapper;
    @MockBean
    private AuthorService authorService;


    @Test
    void testFindAll() {
        List<Author> author = Collections.singletonList(new Author());
        when(authorRepository.findAll()).thenReturn(author);

        List<Author> authorResult = authorService.findAll();
        assertThat(authorResult).isEqualTo(author);
    }

    @Test
    void testGetById() throws Exception {
        Author author = new Author();
        when(authorService
                .findById(author.getId()))
                .thenReturn(author);
        mockMvc.perform(get("api/authors"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("firstName").value("Michail"))
                .andExpect((ResultMatcher) jsonPath("lastName").value("Mihailov"));
    }


    @Test
    void testCreate() throws Exception {
        Author author = new Author();
        when(authorService.create(Mockito.any())).thenReturn(author);
        mockMvc.perform(put("api/authors/{authorId}", "1")
                        .content(objectMapper.writeValueAsString(new Author() {
                        }))
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("firstName").value("Petr"))
                .andExpect((ResultMatcher) jsonPath("lastName").value("Petrov"));
    }

    @Test
    void testUpdate() throws Exception {
        Author author = new Author();
        when(authorService.create(Mockito.any())).thenReturn(author);
        mockMvc.perform(post("api/authors")
                        .content(objectMapper.writeValueAsString(author))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));

        List<Author> authorResult = authorRepository.findAll();
        Assertions.assertFalse(authorResult.isEmpty());
        Assertions.assertNotNull(authorResult.get(0));
    }


    @Test
    void testDelete() throws Exception {
        Author author = new Author();
        when(authorService.findById(Mockito.any())).thenReturn(author);
        mockMvc.perform(delete("api/authors/{authorId}", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));
    }
}
