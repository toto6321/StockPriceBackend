package com.citi.group77777.controller;

import com.citi.group77777.exception.CompanyExceptionNotFound;
import com.citi.group77777.exception.CompanyExceptionSymbolExisted;
import com.citi.group77777.model.Company;
import com.citi.group77777.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Company> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Company> getById(@PathVariable int id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable long id) {
        try {
            service.deleteById(id);
            return "Successfully Deleted.";
        } catch (CompanyExceptionNotFound e) {
            return e.getMessage();
        }
    }

    @PostMapping("")
    public String createOne(@RequestBody Company one) {
        try {
            service.addOne(one);
            return "Successfully Created.";
        } catch (CompanyExceptionSymbolExisted e) {
            return e.message;
        }
    }

    @PutMapping("/{id}")
    public String updateOne(
            @PathVariable long id,
            @RequestBody Company one
    ) {
        try {
            service.updateOne(id, one);
            return "Successfully Updated.";
        } catch (CompanyExceptionNotFound e) {
            return e.message;
        }
    }

}
