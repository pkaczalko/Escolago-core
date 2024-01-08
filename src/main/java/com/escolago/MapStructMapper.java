package com.escolago;


import com.escolago.asset.Asset;
import com.escolago.asset.AssetDTO;
import com.escolago.croom.dto.ItemAssetDTO;
import com.escolago.croom.dto.ItemDTO;
import com.escolago.croom.dto.ItemShortDTO;
import com.escolago.croom.model.Item;
import com.escolago.library.dto.*;
import com.escolago.library.model.*;
import com.escolago.modules.Modules;
import com.escolago.modules.ModulesDTO;
import com.escolago.user.User;
import com.escolago.user.UserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MapStructMapper {
    AuthorDTO authorToAuthorDTO(Author author);

    List<AuthorDTO> authorToAuthorDTO(List<Author> authors);

    @Mapping(target = "published_year", source = "publishedYear")
    @Mapping(target = "book_title", source = "bookTitle")
    BookInfoDTO bookInfoToBookInfoDTO(BookInfo bookInfo);

    @Mapping(source = "published_year", target = "publishedYear")
    @Mapping(source = "book_title", target = "bookTitle")
    BookInfo bookInfoDTOToBookInfo(BookInfoDTO bookInfo);

    List<BookInfoDTO> bookInfoToBookInfoDTO(List<BookInfo> booksInfo);

    List<BookInfo> bookInfoDTOToBookInfo(List<BookInfoDTO> booksInfo);


    @Mapping(target = "date_added", source = "dateAdded")
    @Mapping(target = "_rented", source = "rented")
    @Mapping(target = "asset_id", source = "assetId")
    CopyDTO bookCopyToBookCopyDTO(BookCopy copy);

    List<CopyDTO> bookCopyToBookCopyDTO(List<BookCopy> copies);






    @Mapping(target = "bookInfo", ignore = true)
    @Mapping(target = "rented", source = "_rented")
    @Mapping(target = "dateAdded", source = "date_added")
    @Mapping(target = "assetId", source = "asset_id")
    BookCopy copyDTOtoCopy(CopyDTO c);


    List<BookCopy> copyDTOtoCopy(List<CopyDTO> c);

    GenreDTO genreToGenreDTO(Genre genre);

    List<GenreDTO> genreToGenreDTO(List<Genre> genres);

    LoanDTO loanToLoanDTO(Loan loan);


    @Mapping(target = "copy", ignore = true)
    Loan DtoToLoan(LoanDTO l);

    List<LoanDTO> loansToLoansDTO(List<Loan> loans);

    @Mapping(target = "book_title", source = "bookTitle")
    BookInfoShortDTO bookInfoToShortDTO(BookInfo info);

    List<BookInfoShortDTO> booksInfoToShortDTO(List<BookInfo> booksInfo);

    PagedCatalogueResponseDTO createCatalogueResponse(List<BookInfoShortDTO> catalogue,long totalCount);

    ModulesDTO modulesToDTO(Modules m);
    List<ModulesDTO> modulesToDTO(List<Modules> m);
    Modules DTOtoModule(ModulesDTO module);

    List<Modules> DTOsToModules(List<ModulesDTO> m);

    @Mapping(target = "borrowedBooks", ignore = true)
    @Mapping(ignore = true, target = "role")
    @Mapping(ignore = true, target = "login")
    @Mapping(ignore = true, target = "hash")
    User userDTOtoUser(UserDTO userDTO);



    ItemDTO itemToDTO(Item i);

    List<ItemDTO> itemToDTO(List<Item> i);

    Item DTOToItem(ItemDTO i);
    List<Item> DTOToItem(List<ItemDTO> i);

    ItemShortDTO itemsToShort(Item i);
    List<ItemShortDTO> itemsToShort(List<Item> i);

    AssetDTO assetToDTO(Asset a);

    @Mapping(target = "item", ignore = true)
    @Mapping(target = "book", ignore = true)
    Asset DTOtoAsset(AssetDTO a);


    @Mapping(target = "dateAdded", source = "book.dateAdded")
    @Mapping(target = "copyId", source = "book.id")
    @Mapping(target = "bookId", source = "book.bookInfo.id")
    @Mapping(target = "assetId", source = "id")
    @Mapping(source ="book.bookInfo.bookTitle" ,target ="bookTitle" )
    BookAssetDTO AssetToBookDTO(Asset a);

    @Mapping(target = "addedDate", source = "item.dateAdded")
    @Mapping(target = "name", source = "item.name")
    @Mapping(target = "assetId", source = "id")
    @Mapping(source = "item.id" ,target ="id")
    ItemAssetDTO AssetToItemDTO(Asset a);

}
