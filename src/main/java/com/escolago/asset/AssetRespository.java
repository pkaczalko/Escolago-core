package com.escolago.asset;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AssetRespository extends CrudRepository<Asset, Long>, PagingAndSortingRepository<Asset,Long> {
    Page<Asset> findAllByBook_BookInfo_BookTitleContainsIgnoreCaseOrItem_NameContainingIgnoreCaseOrId(String book_bookInfo_bookTitle, String item_name,Long id, Pageable pageable);
    Page<Asset> findAllByBookIsNotNullOrItemIsNotNull(Pageable pageable);
}
