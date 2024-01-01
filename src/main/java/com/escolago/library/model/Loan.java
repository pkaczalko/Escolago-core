package com.escolago.library.model;

import com.escolago.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @OneToOne(mappedBy = "loan" )
    private BookCopy copy;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
