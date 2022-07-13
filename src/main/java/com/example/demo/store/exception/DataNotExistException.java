package com.example.demo.store.exception;

import javax.persistence.EntityNotFoundException;

public class DataNotExistException extends EntityNotFoundException {

    public DataNotExistException() {
    }

    public DataNotExistException(String message) {
        super(message);
    }

    public DataNotExistException(String whenDoSomething, Class aClass, String id) {
        super(String.format("When: %s, the data is not found, class: %s, id: %s."
                ,whenDoSomething, aClass.getSimpleName(), id));
    }

}
