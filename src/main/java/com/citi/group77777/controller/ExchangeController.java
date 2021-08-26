package com.citi.group77777.controller;

import com.citi.group77777.exception.ExchangeExceptionNotFound;
import com.citi.group77777.exception.ExchangeExceptionSymbolExisted;
import com.citi.group77777.model.Exchange;
import com.citi.group77777.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/exchange")
public class ExchangeController {
    private final ExchangeService service;

    @Autowired
    public ExchangeController(ExchangeService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Exchange> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Exchange> getById(@PathVariable int id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable long id) {
        try {
            service.deleteById(id);
            return "Successfully Deleted.";
        } catch (ExchangeExceptionNotFound e) {
            return e.getMessage();
        }
    }

    @PostMapping("")
    public String createOne(@RequestBody Exchange one) {
        try {
            service.addOne(one);
            return "Successfully Created.";
        } catch (ExchangeExceptionSymbolExisted e) {
            return e.message;
        }
    }

    @PutMapping("/{id}")
    public String updateOne(
            @PathVariable long id,
            @RequestBody Exchange one
    ) {
        try {
            service.updateOne(id, one);
            return "Successfully Updated.";
        } catch (ExchangeExceptionNotFound e) {
            return e.message;
        }
    }

    @GetMapping("/search")
    public List<Exchange> search(
            @RequestParam(value = "symbol", defaultValue = "") String symbol,
            @RequestParam(value = "name", defaultValue = "") String name
    ) {
        List<Exchange> resultSet = new ArrayList<Exchange>();
        if (symbol.length() > 0) {
            resultSet.addAll(service.getBySymbol(symbol));
        }
        if (name.length() > 0) {
            resultSet.addAll(service.getByName(name));
        }
        return resultSet;
    }

}
