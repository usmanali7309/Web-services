package com.rating.service.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String s) {

    }

    public ResourceNotFoundException(){
        super("Resource not found !! ");
    }

}
