package com.escolago.storage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileResponse {
    private String url;

    FileResponse(String name) {
        this.url = name;
    }
}
