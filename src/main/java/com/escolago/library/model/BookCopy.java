package com.escolago.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
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
    @JoinColumn(name = "loan_id", unique = true)
    private Loan loan;


}
