package com.escolago.library.controller;

import com.escolago.library.dto.PagedCatalogueResponseDTO;
import com.escolago.library.mappers.MapStructMapper;
import com.escolago.library.model.BookInfo;
import com.escolago.library.repository.BookInfoRepository;
import com.escolago.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {
    private final LibraryService libraryService;
    @Autowired
    public CatalogueController(
            LibraryService libraryService
    ){
        this.libraryService = libraryService;
    }


    @GetMapping
    private ResponseEntity<PagedCatalogueResponseDTO> getPageOfCatalogue(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "id") String sortBy){
        Pageable pageRequest =  PageRequest.of(page,limit, Sort.by(sortBy));
        return ResponseEntity.ok(libraryService.getPageOfCatalogue(pageRequest));



    }





}
