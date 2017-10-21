package com.taxicalls.driver.resources.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DriverNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DriverNotFoundException(Integer id) {
        super("No such entity: " + id);
    }
}
