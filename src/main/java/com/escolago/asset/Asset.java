package com.escolago.asset;


import com.escolago.croom.model.Item;
import com.escolago.library.model.BookCopy;
import com.escolago.library.model.BookInfo;
import com.escolago.modules.Modules;
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

    @ManyToOne
    @JoinColumn(name="module_id")
    private Modules module;

    @OneToOne(mappedBy = "assetId")
    private BookCopy book;

    @OneToOne(mappedBy = "assetId")
    private Item item;

}
