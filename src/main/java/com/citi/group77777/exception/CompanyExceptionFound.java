package com.citi.group77777.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CompanyExceptionFound extends Throwable {
    public long id;
    public String message;

    public CompanyExceptionFound(Long id) {
        this.id = id;
        this.message = "Operation failed. The company with ID " + id + " is Found!";
    }
}
