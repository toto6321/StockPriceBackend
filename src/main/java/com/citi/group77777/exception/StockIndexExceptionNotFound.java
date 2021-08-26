package com.citi.group77777.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockIndexExceptionNotFound extends Throwable {
    public final long id;
    public final String message;

    public StockIndexExceptionNotFound(long id) {
        this.id = id;
        this.message = "StockPrice with " + id + " is not found!";
    }
}
