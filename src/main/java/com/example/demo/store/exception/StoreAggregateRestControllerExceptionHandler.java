package com.example.demo.store.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.demo.store.controller")
public class StoreAggregateRestControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(StoreAggregateRestControllerExceptionHandler.class);

    @ExceptionHandler({DataNotExistException.class})
    public ResponseEntity handleDataNotExistException(DataNotExistException dataNotExistException){
        log.info(dataNotExistException.getMessage());
        return ResponseEntity.ok(dataNotExistException.getMessage());
    }
}
