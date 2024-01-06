package com.escolago.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDTO {
    private long id;
    private String name;
    private String surname;
    private String role;
}
