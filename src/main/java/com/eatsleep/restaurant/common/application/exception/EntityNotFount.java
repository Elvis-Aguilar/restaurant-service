package com.eatsleep.restaurant.common.application.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class EntityNotFount extends RuntimeException {
    public EntityNotFount(String message) {
        super(message);
    }
}
