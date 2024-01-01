package com.escolago.library.dto;

import com.escolago.user.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class LoanDTO {
    private Integer id;
    private LocalDate dateOfRental;
    private UserDTO user;
}
