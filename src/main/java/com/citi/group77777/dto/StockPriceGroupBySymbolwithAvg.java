package com.citi.group77777.dto;

public class StockPriceGroupBySymbolwithAvg {
    private final String symbol;

    private final double open;

    private final double high;

    private final double low;

    private final double close;

    private final int volume;

    public StockPriceGroupBySymbolwithAvg(String symbol, double open, double high, double low, double close, int volume) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }
}
