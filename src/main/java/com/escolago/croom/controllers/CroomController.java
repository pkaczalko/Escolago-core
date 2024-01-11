package com.escolago.croom.controllers;

import com.escolago.croom.dto.ItemDTO;
import com.escolago.croom.services.CroomService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/croom")
public class CroomController {

    private final CroomService croomService;

    CroomController(CroomService croomService) {
        this.croomService = croomService;
    }

    @GetMapping
    ResponseEntity<?> getItems(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int limit,
                               @RequestParam(defaultValue = "id") String sortBy,
                               @RequestParam(defaultValue = "") String search) {
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(sortBy));
        search = search.replace('+', ' ');
        return ResponseEntity.ok(this.croomService.getPageOfItems(pageRequest, search));
    }

    @GetMapping("item/{id}")
    ResponseEntity<?> getItem(@PathVariable long id) {
        return ResponseEntity.ok(this.croomService.getItemById(id));
    }


    @PostMapping("/item/add")
    ResponseEntity<?> addItem(@RequestBody ItemDTO item){
        ItemDTO savedItem = this.croomService.addItem(item);
        return ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedItem.getId())
                        .toUri()
                )
                .body(savedItem);
    }


    @PutMapping("/item/{id}")
    ResponseEntity<?> updateItem(@PathVariable Long id,@RequestBody ItemDTO item){
        return ResponseEntity.ok(this.croomService.replaceItem(id,item));
    }


    @DeleteMapping("item/{id}")
    ResponseEntity<?> deleteItem(@PathVariable Long id){
        this.croomService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }


}
