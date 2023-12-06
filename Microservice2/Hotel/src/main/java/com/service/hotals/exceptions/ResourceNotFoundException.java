package com.service.hotals.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String s) {

    }

    public ResourceNotFoundException(){
        super("Resource Not Found !!");
    }

}
