package com.escolago.library.dto;


import com.escolago.asset.AssetDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CopyDTO {
    private long id;
    @JsonProperty("rented")
    private boolean is_rented;
    private String link;
    private LocalDate date_added;
    private LoanDTO loan;
    private AssetDTO asset_id;
}
