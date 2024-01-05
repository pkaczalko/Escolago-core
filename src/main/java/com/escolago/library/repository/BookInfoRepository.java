package com.escolago.library.repository;

import com.escolago.library.model.BookInfo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Book;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookInfoRepository extends PagingAndSortingRepository<BookInfo,Long>, CrudRepository<BookInfo,Long> {

    Optional<BookInfo> findBookInfoByIsbn(String isbn);

}
