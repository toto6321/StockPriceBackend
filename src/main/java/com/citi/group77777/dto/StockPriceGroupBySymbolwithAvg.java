package com.citi.group77777.dto;

public class StockPriceGroupBySymbolwithAvg {
    private String symbol;

    private double open;

    private double high;

    private double low;

    private double close;

    private int volume;

    public StockPriceGroupBySymbolwithAvg(String symbol, double open, double high, double low, double close, int volume) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }
}
