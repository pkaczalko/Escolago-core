package com.escolago.library.controller;

import com.escolago.MapStructMapper;
import com.escolago.library.model.Author;
import com.escolago.library.repository.AuthorRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final MapStructMapper mapper;
    AuthorController(AuthorRepository authorRepository, MapStructMapper mapper){
        this.authorRepository = authorRepository;
        this.mapper = mapper;

    }


    @GetMapping("/author/{name}")

    ResponseEntity<?> getAuthorByName(@PathVariable String name){
        name = name.replace('+',' ');
        name = WordUtils.capitalizeFully(name);
        Author author = this.authorRepository.findAuthorByName(name).orElse(null);
        if(author == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.authorToAuthorDTO(author));
    }
}
