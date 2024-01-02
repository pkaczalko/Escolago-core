package com.escolago.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class BookInfoDTO {
    private Long id;
    private List<AuthorDTO> authors;
    private List<GenreDTO> genres;
    private String isbn;
    private String book_title;
    private Integer published_year;
    private String publisher;
    private boolean virtual;
    private String cover;
    private String language;
    private Integer pages;
    private String description;
    private List<CopyDTO> copies;

}
