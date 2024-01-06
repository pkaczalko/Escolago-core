package com.escolago.asset;

import com.escolago.MapStructMapper;
import com.escolago.croom.dto.ItemAssetDTO;
import com.escolago.croom.repositories.ItemRepository;
import com.escolago.library.dto.BookAssetDTO;
import com.escolago.library.repository.BookCopyRepository;
import com.escolago.library.repository.BookInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AssetController {
    private final AssetRespository assetRespository;
    private final BookInfoRepository bookInfoRepository;
    private final BookCopyRepository bookCopyRepository;
    private final ItemRepository itemRepository;
    private final MapStructMapper mapper;
    AssetController(
        AssetRespository assetRespository,
        BookInfoRepository bookInfoRepository,
        ItemRepository itemRepository,
        BookCopyRepository bookCopyRepository,
        MapStructMapper mapper
    ){
        this.assetRespository = assetRespository;
        this.bookInfoRepository = bookInfoRepository;
        this.itemRepository = itemRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.mapper = mapper;
    }


    @GetMapping("/assets")
    ResponseEntity<?> getAllAssets(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int limit,
                                   @RequestParam(defaultValue = "id") String sortBy,
                                   @RequestParam(defaultValue = "") String search){
        long id = -1L;
        try{
            id = Long.parseLong(search);
        }catch (NumberFormatException ignored){}

        Pageable pageRequest =  PageRequest.of(page,limit, Sort.by(sortBy));
        Page<Asset> pageAsset = this.assetRespository.findAllByBook_BookInfo_BookTitleContainsIgnoreCaseOrItem_NameContainingIgnoreCaseOrId(search,search,id,pageRequest);
        List<JoinAssetsDTO> allAssets = this.getAssets(pageAsset.getContent());
        AssetPagedResponse response = new AssetPagedResponse(pageAsset.getTotalElements(), allAssets);
        return ResponseEntity.ok(response);
    }


    @GetMapping("assets/last")
    ResponseEntity<?> getLastAdded(){
        Pageable pageRequest =  PageRequest.of(0,5, Sort.by(Sort.Order.desc("id")));
        return ResponseEntity.ok(this.getAssets(this.assetRespository.findAll(pageRequest).getContent()));
    }


   List<JoinAssetsDTO> getAssets(List<Asset> assets){
        List<JoinAssetsDTO> list = new ArrayList<>();
       assets.forEach(asset -> {
           JoinAssetsDTO joinAsset = new JoinAssetsDTO();
           if(asset.getBook() != null){
               BookAssetDTO temp = this.mapper.AssetToBookDTO(asset);
               joinAsset.setBook(temp);
           }else if(asset.getItem() != null) {
               ItemAssetDTO temp = this.mapper.AssetToItemDTO(asset);
               joinAsset.setItem(temp);
           }else {return;}
           list.add(joinAsset);
       });
       return list;
   }


}
