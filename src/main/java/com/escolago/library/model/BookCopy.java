package com.escolago.library.model;

import com.escolago.asset.Asset;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    @JsonBackReference
    @JoinColumn(name = "loan_id", unique = true)
    private Loan loan;

    @OneToOne
    @JoinColumn(name = "asset_id", unique = true,nullable = false)
    private Asset asset_id;

}
