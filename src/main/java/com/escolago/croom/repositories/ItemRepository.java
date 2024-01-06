package com.escolago.croom.repositories;

import com.escolago.croom.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item,Long>, CrudRepository<Item,Long> {
    Page<Item> findAllByNameContainingIgnoreCaseOrKeywordsContainingIgnoreCaseOrDescriptionIsContainingIgnoreCaseOrCategories_nameContainingIgnoreCaseOrAssetId_idEquals(String name, String keywords, String description, String categories_name, long assetId_id, Pageable pageable);
}
