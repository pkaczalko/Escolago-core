package com.escolago.library.service;

import com.escolago.asset.Asset;
import com.escolago.asset.AssetRespository;
import com.escolago.library.dto.BookInfoDTO;
import com.escolago.library.dto.CopyDTO;
import com.escolago.library.dto.PagedCatalogueResponseDTO;
import com.escolago.library.mappers.MapStructMapper;
import com.escolago.library.model.BookCopy;
import com.escolago.library.model.BookInfo;
import com.escolago.library.model.Loan;
import com.escolago.library.repository.BookCopyRepository;
import com.escolago.library.repository.BookInfoRepository;
import com.escolago.library.repository.LoanRepository;
import com.escolago.user.User;
import com.escolago.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private  final MapStructMapper mapstructMapper;
    private final BookInfoRepository bookInfoRepository;
    private final BookCopyRepository bookCopyRepository;
    private final AssetRespository assetRespository;
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
@Autowired
    public LibraryService(
            MapStructMapper mapstructMapper,
            BookInfoRepository bookInfoRepository,
            BookCopyRepository bookCopyRepository,
            AssetRespository assetRespository,
            LoanRepository loanRepository,
            UserRepository userRepository
    ){
        this.mapstructMapper = mapstructMapper;
        this.bookInfoRepository = bookInfoRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.assetRespository = assetRespository;
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
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




    public void asignAssetId(BookCopy copy){
        Asset newA = new Asset();
        assetRespository.save(newA);
        copy.setAsset_id(newA);
    }


    public List<CopyDTO> saveNewCopies(long id,List<CopyDTO> list){
    List<BookCopy> copiesToSave = mapstructMapper.copiesDTOtoCopies(list);
    copiesToSave.forEach(this::asignAssetId);
    List<BookCopy> savedCopies = (List<BookCopy>) bookCopyRepository.saveAll(copiesToSave);
    this.bookInfoRepository.findById(id).ifPresent(  book ->{
        book.addCopies(savedCopies);
        this.bookInfoRepository.save(book);
            }

    );
        return mapstructMapper.booksCopiesToBooksCopiesDTO(savedCopies);
    }



    public CopyDTO rentACopy(Long user_id,CopyDTO copy){
        BookCopy copyToRent = mapstructMapper.copyDTOtoCopy(copy);

        User userData = this.userRepository.findById(user_id).get();
        Loan loanInfo = new Loan(copyToRent,userData);
        this.loanRepository.save(loanInfo);
        copyToRent.set_rented(true);
        copyToRent.setLoan(loanInfo);
        return mapstructMapper.bookCopyToBookCopyDTO(bookCopyRepository.save(copyToRent));
    }


    public CopyDTO returnCopy(Integer loan_id,CopyDTO copy){
        copy.setLoan(null);
        copy.set_rented(false);
        BookCopy copyToReturn = mapstructMapper.copyDTOtoCopy(copy);
        bookCopyRepository.save(copyToReturn);
        loanRepository.deleteById(loan_id);

        return mapstructMapper.bookCopyToBookCopyDTO(copyToReturn);
    }

}
