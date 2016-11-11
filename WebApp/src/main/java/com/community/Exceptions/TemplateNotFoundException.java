package com.community.Exceptions;

/**
 * Represents an error that occurs if a specified template file does not exist.
 */
public class TemplateNotFoundException extends RuntimeException {
    public TemplateNotFoundException(String details){
        super(details);
    }
}
