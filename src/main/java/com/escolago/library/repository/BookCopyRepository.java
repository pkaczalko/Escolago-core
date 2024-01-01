package com.escolago.library.repository;

import com.escolago.library.model.BookCopy;
import org.springframework.data.repository.CrudRepository;

public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {
}
