package com.example.productimage.exceptions;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
public class GenericDataMissingException extends RuntimeException{

    public GenericDataMissingException(final String message, final Exception e) {
        super(message, e);
    }
    public GenericDataMissingException(final String message) {
        super(message);
    }

}
