package com.escolago.user;

import com.escolago.library.Loans;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(max = 25)
    private String name;
    @Size(max = 50)
    private String surname;
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonRole role;
    @Size(max = 25)
    private String login;
    private String hash;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Loans> borrowedBooks;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setRole(JsonRole role) {
        this.role = role;
    }
}
