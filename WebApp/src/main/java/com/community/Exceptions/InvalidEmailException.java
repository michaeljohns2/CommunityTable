package com.community.Exceptions;

/**
 * Created by keljd on 11/8/2016.
 */
public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String details){
        super(details);
    }
}
