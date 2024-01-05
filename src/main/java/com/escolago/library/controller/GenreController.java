package com.escolago.library.controller;

import com.escolago.library.mappers.MapStructMapper;
import com.escolago.library.model.Genre;
import com.escolago.library.repository.GenreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    private final MapStructMapper mapper;
    private final GenreRepository genreRepository;
    GenreController(GenreRepository genreRepository, MapStructMapper mapper){
        this.genreRepository = genreRepository;
        this.mapper = mapper;

    }


    @GetMapping("/genre/{name}")
    ResponseEntity<?> getGenreByNames(@PathVariable String name){
        name = name.replace('+',' ');

        Genre genre = this.genreRepository.findGenreByNameOrEnglishName(name,name).orElse(null);
        if(genre == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.genreToGenreDTO(genre));
    }
}
