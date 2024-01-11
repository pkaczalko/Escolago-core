package com.escolago.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book_info")
public class BookInfo {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
 @JoinTable(name = "authors_of_book",
         joinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id"),
         inverseJoinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id")
 )
    private List<Author> authors = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "genres_of_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genere_id", referencedColumnName = "id")
    )
    private List<Genre> genres = new ArrayList<>();
    private String isbn;
    @Column(name="book_title")
    private String bookTitle;
    @Column(name="published_year")
    private Integer publishedYear;
    private String publisher;
    private boolean virtual;
    private String cover;
    private String language;
    private Integer pages;
    private String description;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bookInfo")
    private List<BookCopy> copies = new ArrayList<>();

   public void addCopy(BookCopy copy){
      copies.add(copy);
   }

   public void addCopies(List<BookCopy> newCopies){
      newCopies.forEach(this::addCopy);
   }

}
