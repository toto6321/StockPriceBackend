package com.citi.group77777.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StockIndexExceptionSymbolAndDateExisted extends Throwable {
    public String symbol;
    public LocalDate date;
    public String message;

    public StockIndexExceptionSymbolAndDateExisted(String symbol, LocalDate date) {
        this.symbol = symbol;
        this.date = date;
        this.message = "Operation failed. The stock price with symbol " + symbol + " and Date " + date + " has been existed!";
    }
}
