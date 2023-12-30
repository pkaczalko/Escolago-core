package com.escolago.library;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dateOfRental;

    public Loans() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateOfRental() {
        return dateOfRental;
    }

    public void setDateOfRental(LocalDate dateOfRental) {
        this.dateOfRental = dateOfRental;
    }
}
