package com.escolago.library.Exceptions;

import lombok.experimental.StandardException;

@StandardException
public class BookAlreadyExistsException extends Exception {
    public BookAlreadyExistsException(String message){
        super(message);
    }
}
