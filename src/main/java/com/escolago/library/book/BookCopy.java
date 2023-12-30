package com.escolago.library.book;

import com.escolago.library.Loans;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="book_copy")
public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean is_rented;
    private String link;
    private LocalDate date_added;
    @OneToOne
    private Loans loans;

    public BookCopy() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIs_rented() {
        return is_rented;
    }

    public void setIs_rented(boolean is_rented) {
        this.is_rented = is_rented;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getDate_added() {
        return date_added;
    }

    public void setDate_added(LocalDate date_added) {
        this.date_added = date_added;
    }
}
