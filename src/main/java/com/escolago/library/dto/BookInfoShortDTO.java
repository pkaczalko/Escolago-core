package com.escolago.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookInfoShortDTO {
    private Long id;
    private List<AuthorDTO> authors;
    private List<GenreDTO> genres;
    private String isbn;
    private String book_title;
    private String cover;
}
