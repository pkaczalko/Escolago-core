package com.escolago.croom.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ItemAssetDTO {
    private String name;
    private Long id;
    private Long assetId;
    private LocalDate addedDate;
}
