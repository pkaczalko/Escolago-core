package com.escolago.croom.services;

import com.escolago.asset.Asset;
import com.escolago.asset.AssetRespository;
import com.escolago.MapStructMapper;
import com.escolago.croom.dto.ItemDTO;
import com.escolago.croom.dto.PagedItemsResponseDTO;
import com.escolago.croom.model.Item;
import com.escolago.croom.model.ItemCategory;
import com.escolago.croom.repositories.CategoryRepository;
import com.escolago.croom.repositories.ItemRepository;
import com.escolago.modules.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CroomService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ModuleRepository moduleRepository;
    private final AssetRespository assetRespository;
    private final MapStructMapper mapper;

    @Autowired
    CroomService(
            ItemRepository itemRepository,
            CategoryRepository categoryRepository,
            ModuleRepository moduleRepository,
            AssetRespository assetRespository,
            MapStructMapper mapper
    ){
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
        this.moduleRepository = moduleRepository;
        this.assetRespository = assetRespository;
        this.mapper = mapper;
    }


    public Optional<ItemDTO> getItemById(Long id){
        return this.itemRepository.findById(id).map(mapper::itemToDTO);

    }

    public PagedItemsResponseDTO getPageOfItems(Pageable pageRequest, String name){
        Page<Item> items;
        if(!name.isBlank()){
            long id = -1L;
            try{
                id = Long.parseLong(name);
            }catch (NumberFormatException ignored){}
            finally {
                items = this.itemRepository
                        .findAllByNameContainingIgnoreCaseOrKeywordsContainingIgnoreCaseOrDescriptionIsContainingIgnoreCaseOrCategories_nameContainingIgnoreCaseOrAssetId_idEquals(name,name,name,name,id,pageRequest);
            }
        }
        else {
            items = this.itemRepository.findAll(pageRequest);
        }
        PagedItemsResponseDTO response = new PagedItemsResponseDTO();
        response.setTotalCount(items.getTotalElements());
        response.setItems(mapper.itemsToShort(items.getContent()));
        return response;

    }


    Item assignItemAsset(Item item){
        Asset newAsset = new Asset();
        newAsset.setModule(this.moduleRepository.findById(2).get());
        item.setAssetId(this.assetRespository.save(newAsset));
        return item;
    }

   public List<ItemCategory> findCategory(List<ItemCategory> categories){
        categories.forEach(category ->{
            String name = category.getName();
            Optional<ItemCategory> temp = this.categoryRepository.findByName(name);
            if (temp.isPresent()){
                category.setId(temp.get().getId());
                category.setName(temp.get().getName());
            }
        });
        return categories;
    }

 public   ItemDTO addItem(ItemDTO item){
        Item newItem = this.mapper.DTOToItem(item);
       return this.mapper.itemToDTO(this.itemRepository.save(this.assignItemAsset(newItem)));
    }

public Optional<ItemDTO> replaceItem(long id,ItemDTO item){
        if(this.itemRepository.findById(id).isEmpty()){
            return Optional.empty();
        }
        item.setId(id);
        return Optional.of(this.mapper.itemToDTO(this.itemRepository.save(this.mapper.DTOToItem(item))));
    }

  public  void deleteItem(Long id){
        this.itemRepository.deleteById(id);
    }
}
