package com.citi.group77777.exception;

public class ExchangeExceptionSymbolExisted extends Exception {
    public String symbol;
    public String message;

    public ExchangeExceptionSymbolExisted(String symbol) {
        this.symbol = symbol;
        this.message = "Operation failed. The exchange with symbol " + symbol + " has been existed!";
    }
}
