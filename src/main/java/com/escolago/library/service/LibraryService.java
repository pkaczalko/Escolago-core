package com.escolago.library.service;

import com.escolago.library.dto.AuthorDTO;
import com.escolago.library.dto.BookInfoDTO;
import com.escolago.library.dto.PagedCatalogueResponseDTO;
import com.escolago.library.mappers.MapStructMapper;
import com.escolago.library.model.Author;
import com.escolago.library.model.BookInfo;
import com.escolago.library.repository.BookInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private  final MapStructMapper mapstructMapper;
    private final BookInfoRepository bookInfoRepository;
@Autowired
    public LibraryService(
            MapStructMapper mapstructMapper,
            BookInfoRepository bookInfoRepository
    ){
        this.mapstructMapper = mapstructMapper;
        this.bookInfoRepository = bookInfoRepository;
    }



    public PagedCatalogueResponseDTO getPageOfCatalogue(Pageable pageRequest){
        Page<BookInfo> catalogue = bookInfoRepository.findAll(pageRequest);
        PagedCatalogueResponseDTO response = new PagedCatalogueResponseDTO();
        response.setTotalCount(catalogue.getTotalElements());
        response.setCatalogue(mapstructMapper.booksInfoToShortDTO(catalogue.getContent()));
        return response;

    }


   public Optional<BookInfoDTO> getBookById(Long id){
       bookInfoRepository.findById(id)
               .ifPresent(mapstructMapper::bookInfoToBookInfoDTO);
       return bookInfoRepository.findById(id).map(mapstructMapper::bookInfoToBookInfoDTO);

    }


    public Optional<BookInfoDTO> replaceBookInfo(Long id,BookInfoDTO bookInfoDTO){
    if(!bookInfoRepository.existsById(id)){
        return Optional.empty();
    }
    bookInfoDTO.setId(id);
    BookInfo bookToUpdate = mapstructMapper.bookInfoDTOToBookInfo(bookInfoDTO);
    BookInfo updatedBook = bookInfoRepository.save(bookToUpdate);
    return Optional.of(mapstructMapper.bookInfoToBookInfoDTO(updatedBook));
    }



}
