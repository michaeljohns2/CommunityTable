package com.community.Exceptions;

/**
 * Created by keljd on 11/6/2016.
 */
public class ApiServerException extends RuntimeException {

    public ApiServerException(String details){
        super(details);
    }
}
