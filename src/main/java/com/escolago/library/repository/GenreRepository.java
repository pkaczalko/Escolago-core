package com.escolago.library.repository;

import com.escolago.library.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre,Integer> {
    Optional<Genre> findGenreByNameOrEnglishName(String name, String englishName);
}
