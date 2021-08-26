package com.citi.group77777.controller;

import com.citi.group77777.exception.StockIndexExceptionNotFound;
import com.citi.group77777.exception.StockIndexExceptionSymbolAndDateExisted;
import com.citi.group77777.model.StockIndex;
import com.citi.group77777.service.StockIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/stockindex")
public class StockIndexController {

    private final StockIndexService service;

    @Autowired
    public StockIndexController(StockIndexService service) {
        this.service = service;
    }

    @GetMapping()
    public List<StockIndex> getPage(@RequestParam int pageSize, @RequestParam int page) {
        return service.getPage(pageSize, page);
    }

    @GetMapping("/{id}")
    public StockIndex getById(@PathVariable int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable long id) {
        try {
            service.deleteById(id);
            return "Successfully Deleted.";
        } catch (StockIndexExceptionNotFound e) {
            return e.getMessage();
        }
    }

    @PostMapping("")
    public String createOne(@RequestBody StockIndex one) {
        try {
            service.addOne(one);
            return "Successfully Created.";
        } catch (StockIndexExceptionSymbolAndDateExisted e) {
            return e.message;
        }
    }

    @PutMapping("/{id}")
    public String updateOne(
            @PathVariable long id,
            @RequestBody StockIndex one
    ) {
        try {
            service.updateOne(id, one);
            return "Successfully Updated.";
        } catch (StockIndexExceptionNotFound e) {
            return e.message;
        }
    }
}
