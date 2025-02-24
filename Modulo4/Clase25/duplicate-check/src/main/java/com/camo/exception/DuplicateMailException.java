package com.camo.exception;

public class DuplicateMailException extends Exception {
    public DuplicateMailException (String message){
        super(message);
    }
}
