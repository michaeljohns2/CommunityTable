package com.community.Exceptions;

/**
 * This class represents a general exception in the REST API.
 */
public class ApiException extends RuntimeException {

    public ApiException(String details){
        super(details);
    }
}
