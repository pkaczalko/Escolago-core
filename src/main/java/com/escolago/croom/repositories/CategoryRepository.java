package com.escolago.croom.repositories;

import com.escolago.croom.model.ItemCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<ItemCategory,Long> {
    Optional<ItemCategory> findByName(String name);
}
