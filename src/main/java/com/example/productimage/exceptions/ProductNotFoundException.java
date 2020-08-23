package com.example.productimage.exceptions;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(final String message, final Exception e) {
        super(message, e);
    }
    public ProductNotFoundException(final String message) {
        super(message);
    }

}
