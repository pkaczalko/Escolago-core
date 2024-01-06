package com.escolago.library.dto;

import com.escolago.asset.AssetDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookAssetDTO {
    private String bookTitle;
    private Long bookId;
    private Long copyId;
    private Long assetId;
    private LocalDate dateAdded;
}
