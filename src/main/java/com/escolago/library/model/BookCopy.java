package com.escolago.library.model;

import com.escolago.asset.Asset;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name="book_copy")
public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="is_rented")
    @JsonProperty("rented")
    private boolean isRented;
    private String link;
    @Column(name="date_added")
    private LocalDate dateAdded;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "loan_id", unique = true)
    private Loan loan;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "asset_id", unique = true,nullable = false)
    private Asset assetId;

    @ManyToOne()
    @JsonBackReference
    @ToStringExclude
    @JoinColumn(name="book_id",nullable = false)
    private BookInfo bookInfo;
}
