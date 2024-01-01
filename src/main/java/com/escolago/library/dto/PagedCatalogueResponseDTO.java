package com.escolago.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PagedCatalogueResponseDTO {
    private long totalCount;
    private List<BookInfoShortDTO> catalogue;
}
