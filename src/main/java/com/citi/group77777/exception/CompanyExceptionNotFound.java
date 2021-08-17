package com.citi.group77777.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CompanyExceptionNotFound extends Throwable {
    public long id;
    public String message;

    public CompanyExceptionNotFound(Long id) {
        this.id = id;
        this.message = "Operation failed. The company with ID " + id + " is Not Found!";
    }
}
