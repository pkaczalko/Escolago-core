package com.escolago.library.model;

import com.escolago.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dateOfRental;
    @OneToOne(mappedBy = "loan",fetch=FetchType.LAZY,cascade = CascadeType.MERGE)
    private BookCopy copy;

    @ManyToOne(fetch=FetchType.LAZY)
    @ToString.Exclude
    @JsonBackReference
    private User user;


    public Loan(BookCopy copy, User user) {
        this.dateOfRental = LocalDate.now();
        this.copy = copy;
        this.user = user;
    }

    public Loan() {
    }
}
