package com.escolago.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class JsonRole implements Serializable {
    private String job;

    private boolean admin;

    private String[] module;

}
