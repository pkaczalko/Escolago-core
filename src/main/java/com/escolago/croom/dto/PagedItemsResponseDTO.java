package com.escolago.croom.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PagedItemsResponseDTO {
    private long totalCount;
    private List<ItemShortDTO> items;
}
