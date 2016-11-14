package com.community.Exceptions;

public class EmailSendException extends Exception {
    public EmailSendException(String details){
        super(details);
    }
}
