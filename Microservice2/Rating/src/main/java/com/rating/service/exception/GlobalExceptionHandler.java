package com.rating.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String,Object>> resourceNotFound(ResourceNotFoundException ex){

        Map map = new HashMap<>();
        map.put("message",ex.getMessage());
        map.put("success",false);
        map.put("status", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }
}
