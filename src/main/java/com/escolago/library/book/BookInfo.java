package com.escolago.library.book;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_info")
public class BookInfo {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 @ManyToMany
 @JoinTable(name = "authors_of_book",
         joinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id"),
         inverseJoinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id")
 )
    private List<Author> authors = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "generes_of_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genere_id", referencedColumnName = "id")
    )
    private List<Genre> genres = new ArrayList<>();
    private String isbn;
    private String book_title;
    private Integer published_year;
    private String publisher;
    private boolean virtual;
    private String cover;
    private String language;
    private Integer pages;
    private String description;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<BookCopy> copies = new ArrayList<>();

    public BookInfo() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public Integer getPublished_year() {
        return published_year;
    }

    public void setPublished_year(Integer published_year) {
        this.published_year = published_year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
