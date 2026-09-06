package com.crud.demo.exception;

public class DuplicateEmailEntryException extends RuntimeException{

    public DuplicateEmailEntryException(String message) {
        super(message);
    }
}
