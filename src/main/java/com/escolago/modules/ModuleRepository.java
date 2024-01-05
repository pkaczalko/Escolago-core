package com.escolago.modules;

import com.escolago.library.model.BookInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Modules, Integer> {
    @Override
    List<Modules> findAll();
}
