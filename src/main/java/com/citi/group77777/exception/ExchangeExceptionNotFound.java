package com.citi.group77777.exception;

public class ExchangeExceptionNotFound extends Exception {
    public long id;
    public String message;

    public ExchangeExceptionNotFound(Long id) {
        this.id = id;
        this.message = "Operation failed. The exchange with ID " + id + " is Not Found!";
    }
}
