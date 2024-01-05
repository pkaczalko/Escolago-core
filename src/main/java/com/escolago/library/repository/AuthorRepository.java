package com.escolago.library.repository;

import com.escolago.library.dto.AuthorDTO;
import com.escolago.library.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
    Optional<Author> findAuthorByName(String Name);
}
