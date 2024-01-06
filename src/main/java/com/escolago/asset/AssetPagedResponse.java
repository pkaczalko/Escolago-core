package com.escolago.asset;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AssetPagedResponse {
    private Long totalElements;
    private List<JoinAssetsDTO> assets;

    AssetPagedResponse(Long t, List<JoinAssetsDTO> l){
        this.totalElements = t;
        this.assets = l;
    }
}
