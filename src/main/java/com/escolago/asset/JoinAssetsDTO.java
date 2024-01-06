package com.escolago.asset;

import com.escolago.croom.dto.ItemAssetDTO;
import com.escolago.library.dto.BookAssetDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinAssetsDTO {
    private ItemAssetDTO item;
    private BookAssetDTO book;
}
