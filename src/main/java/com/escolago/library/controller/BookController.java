package com.escolago.library.controller;


import com.escolago.library.Exceptions.BookAlreadyExistsException;
import com.escolago.library.dto.BookInfoDTO;
import com.escolago.library.dto.CopyDTO;
import com.escolago.library.mappers.MapStructMapper;
import com.escolago.library.model.BookCopy;
import com.escolago.library.model.BookInfo;
import com.escolago.library.repository.BookInfoRepository;
import com.escolago.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private final MapStructMapper mapstructMapper;
    private final BookInfoRepository bookInfoRepository;
    private final LibraryService libraryService;

    @Autowired
    public BookController(MapStructMapper mapstructMapper, BookInfoRepository bookInfoRepository, LibraryService libraryService){
        this.mapstructMapper = mapstructMapper;
        this.bookInfoRepository = bookInfoRepository;
        this.libraryService = libraryService;

    }


    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(
                mapstructMapper.booksInfoToBooksInfoDTO(
                        (List<BookInfo>) bookInfoRepository.findAll()
                ),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookInfoDTO>> getById(
            @PathVariable(value="id") long id
    ){
        return ResponseEntity.ok(libraryService.getBookById(id));

    }


    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable Long id, @RequestBody BookInfoDTO updateDto) {
        return libraryService.replaceBookInfo(id,updateDto).map(c-> ResponseEntity.noContent().build()).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/addcopy")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> addCopys(@PathVariable Long id, @RequestBody List<CopyDTO> copies){
        return ResponseEntity.ok(this.libraryService.saveNewCopies(id,copies));
    }



    @PutMapping("/rent/{user_id}")
    ResponseEntity<?> rentBook(@PathVariable Long user_id, @RequestBody CopyDTO copy){
        CopyDTO result = this.libraryService.rentACopy(user_id,copy);
        if(result == null){
            return ResponseEntity.notFound().build();
        }else{
        return ResponseEntity.ok(result);
        }
    }


    @PutMapping("/return/{loan_id}")
    ResponseEntity<?> returnBook(@PathVariable Integer loan_id,@RequestBody CopyDTO copy){
        return ResponseEntity.ok(this.libraryService.returnCopy(loan_id,copy));
    }


    @DeleteMapping("/copy/delete/{copy_id}")
    ResponseEntity<?> deleteCopy(@PathVariable Long copy_id){
        this.libraryService.deleteCopy(copy_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/renals/{id}")
    ResponseEntity<?> getRentals(@PathVariable Long id){
       return ResponseEntity.ok(this.libraryService.rentals(id));
    }


    @PostMapping("/add")
    ResponseEntity<?> addBook(@RequestBody BookInfoDTO book) {
        try {
            BookInfoDTO savedBook = this.libraryService.addBook(book);
            return ResponseEntity.created(ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedBook.getId())
                            .toUri()
                    )
                    .body(savedBook);
        }catch (BookAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id){
        this.bookInfoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
