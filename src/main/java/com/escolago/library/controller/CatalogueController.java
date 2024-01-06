package com.escolago.library.controller;

import com.escolago.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     ResponseEntity<?> getPageOfCatalogue(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int limit,
                                          @RequestParam(defaultValue = "id") String sortBy,
                                          @RequestParam(defaultValue = "") String search,
                                          @RequestParam(defaultValue = "") String action){
        Pageable pageRequest =  PageRequest.of(page,limit,Sort.by(sortBy));
        search =  search.replace('+',' ');
        return ResponseEntity.ok(libraryService.getPageOfCatalogue(pageRequest,search,action));

        }






}
