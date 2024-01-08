package com.escolago.croom.model;

import com.escolago.asset.Asset;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String link;
    private String keywords;
    private String description;
    private LocalDate dateAdded;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "item_category_items",
            joinColumns = @JoinColumn(name = "items_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id", referencedColumnName = "id")
    )
    private List<ItemCategory> categories = new ArrayList<>();

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "asset_id", unique = true,nullable = false)
    private Asset assetId;

}
