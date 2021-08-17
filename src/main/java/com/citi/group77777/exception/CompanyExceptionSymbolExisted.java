package com.citi.group77777.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CompanyExceptionSymbolExisted extends Throwable {
    public String symbol;
    public String message;

    public CompanyExceptionSymbolExisted(String symbol) {
        this.symbol = symbol;
        this.message = "Operation failed. The company with symbol " + symbol + " has been existed!";
    }
}
