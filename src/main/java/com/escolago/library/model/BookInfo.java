package com.escolago.library.model;

import com.escolago.library.dto.CopyDTO;
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


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
 @JoinTable(name = "authors_of_book",
         joinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id"),
         inverseJoinColumns = @JoinColumn(name = "id_author", referencedColumnName = "id")
 )
    private List<Author> authors = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
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
    @OneToMany(orphanRemoval = true,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<BookCopy> copies = new ArrayList<>();

   public void addCopy(BookCopy copy){
      copies.add(copy);
   }

   public void addCopies(List<BookCopy> newCopies){
      newCopies.forEach(this::addCopy);
   }

}
