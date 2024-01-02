package com.escolago.asset;


import com.escolago.library.model.BookCopy;
import com.escolago.library.model.BookInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


}
