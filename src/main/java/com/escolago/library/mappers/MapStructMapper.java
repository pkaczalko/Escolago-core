package com.escolago.library.mappers;


import com.escolago.library.dto.*;
import com.escolago.library.model.*;
import com.escolago.user.User;
import com.escolago.user.UserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;


import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MapStructMapper {
    AuthorDTO authorToAuthorDTO(Author author);
    List<AuthorDTO> authorsToAuthorsDTO(List<Author> authors);
    BookInfoDTO bookInfoToBookInfoDTO(BookInfo bookInfo);
    BookInfo bookInfoDTOToBookInfo(BookInfoDTO bookInfo);
    List<BookInfoDTO> booksInfoToBooksInfoDTO(List<BookInfo> booksInfo);
    List<BookInfo> booksInfoDTOToBooksInfo(List<BookInfoDTO> booksInfo);
    CopyDTO bookCopyToBookCopyDTO(BookCopy copy);
    List<CopyDTO> booksCopiesToBooksCopiesDTO(List<BookCopy> copies);
    GenreDTO genreToGenreDTO(Genre genre);
    List<GenreDTO> genresToGenresDTO(List<Genre> genres);
    LoanDTO loanToLoanDTO(Loan loan);
    List<LoanDTO> loansToLoansDTO(List<Loan> loans);

    BookInfoShortDTO bookInfoToShortDTO(BookInfo info);
    List<BookInfoShortDTO> booksInfoToShortDTO(List<BookInfo> booksInfo);

    PagedCatalogueResponseDTO createCatalogueResponse(List<BookInfoShortDTO> catalogue,long totalCount);


    @Mapping(target = "borrowedBooks", ignore = true)
    @Mapping(ignore = true, target = "role")
    @Mapping(ignore = true, target = "login")
    @Mapping(ignore = true, target = "hash")
    User userDTOtoUser(UserDTO userDTO);
}
