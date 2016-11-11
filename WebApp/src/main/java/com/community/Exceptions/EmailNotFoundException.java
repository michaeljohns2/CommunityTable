package com.community.Exceptions;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String details){
        super(details);
    }
}
