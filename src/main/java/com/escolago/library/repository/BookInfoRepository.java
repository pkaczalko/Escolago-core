package com.escolago.library.repository;

import com.escolago.library.model.BookInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface BookInfoRepository extends PagingAndSortingRepository<BookInfo,Long>, CrudRepository<BookInfo,Long> {

    Optional<BookInfo> findBookInfoByIsbn(String isbn);

    Page<BookInfo> findAllByBookTitleContainingIgnoreCase(String bookTitle, Pageable pageable);

    Page<BookInfo> findAllByIsbnContainingIgnoreCase(String isbn, Pageable pageable);

    Page<BookInfo> findAllByAuthors_nameContainingIgnoreCase(String authors_name, Pageable pageable);

    Page<BookInfo> findAllByGenres_nameContainingIgnoreCase(String genres_name, Pageable pageable);

    Page<BookInfo> findAllByCopies_assetId_id(long copies_assetId_id, Pageable pageable);


}
