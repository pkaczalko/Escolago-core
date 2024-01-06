package com.escolago.croom.dto;

import com.escolago.asset.AssetDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ItemShortDTO {
    private Long id;
    private String name;
    private String keywords;
    private List<ItemCategoryDTO> categories;
    private AssetDTO assetId;
}
