package com.service.hotals.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    public ResponseEntity<Map<String,Object>> resourceNotFoundException(ResourceNotFoundException ex){

        Map<String,Object> map = new HashMap<>();
        map.put("message",ex.getMessage());
        map.put("success",false);
        map.put("status", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    }
}
