package com.escolago.user;

import com.escolago.library.model.Loan;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Entity
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(max = 25)
    private String name;
    @Size(max = 50)
    private String surname;

    private String role;
    @Size(max = 25)
    private String login;
    private String hash;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Loan> borrowedBooks;

}
