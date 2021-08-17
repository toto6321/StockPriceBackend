package com.citi.group77777.controller;

import com.citi.group77777.dto.StockPriceGroupBySymbolwithAvg;
import com.citi.group77777.exception.StockPriceExceptionNotFound;
import com.citi.group77777.exception.StockPriceExceptionSymbolAndDateExisted;
import com.citi.group77777.model.StockPrice;
import com.citi.group77777.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/stockprice")
public class StockPriceController {

    private final StockPriceService service;

    @Autowired
    public StockPriceController(StockPriceService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<StockPrice> getAll() {
        return service.getAll();
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

    @GetMapping("/avg")
    public List<StockPriceGroupBySymbolwithAvg> getAVG() {
        return service.getAVG();
    }

}
