package com.citi.group77777.controller;

import com.citi.group77777.exception.StockPriceExceptionNotFound;
import com.citi.group77777.exception.StockPriceExceptionSymbolAndDateExisted;
import com.citi.group77777.model.StockPrice;
import com.citi.group77777.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Configuration
@RestController
@RequestMapping("/api/v1/stockprice")
public class StockPriceController {

    private final StockPriceService service;

    @Autowired
    public StockPriceController(StockPriceService service) {
        this.service = service;
    }

    @GetMapping()
    public List<StockPrice> getPage(@RequestParam int pageSize, @RequestParam int page) {
        return service.getPage(pageSize, page);
    }

    @GetMapping("/{id}")
    public StockPrice getById(@PathVariable int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable long id) {
        try {
            service.deleteById(id);
            return "Successfully Deleted.";
        } catch (StockPriceExceptionNotFound e) {
            return e.getMessage();
        }
    }

    @PostMapping("")
    public String createOne(@RequestBody StockPrice one) {
        try {
            service.addOne(one);
            return "Successfully Created.";
        } catch (StockPriceExceptionSymbolAndDateExisted e) {
            return e.message;
        }
    }

    @PutMapping("/{id}")
    public String updateOne(
            @PathVariable long id,
            @RequestBody StockPrice one
    ) {
        try {
            service.updateOne(id, one);
            return "Successfully Updated.";
        } catch (StockPriceExceptionNotFound e) {
            return e.message;
        }
    }

    @GetMapping("/symbol/{symbol}")
    public List<StockPrice> getBySymbol(
            @PathVariable("symbol") String symbol,
            @RequestParam(value = "begin", defaultValue = "") final String begin,
            @RequestParam(value = "end", defaultValue = "") final String end
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate be = LocalDate.EPOCH;
        LocalDate en = LocalDate.now();
        if (end.length() > 0) {
            try {
                en = LocalDate.parse(end, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
        }
        if (begin.length() > 0) {
            try {
                be = LocalDate.parse(begin, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
        }
        return service.getBySymbolAndDateRange(symbol, be, en);
    }

}
