package com.citi.group77777.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class RootController {
    private final StockPriceController stockPrice;
    private final CompanyController company;

    @Autowired
    public RootController(StockPriceController stockPrice, CompanyController company) {
        this.stockPrice = stockPrice;
        this.company = company;
    }

}
