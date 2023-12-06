package com.micro.user.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String s) {

    }

    public ResourceNotFoundException(){
        super("Resource not found !!");
    }

}
