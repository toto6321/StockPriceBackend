package com.citi.group77777.service;

import com.citi.group77777.exception.CompanyExceptionNotFound;
import com.citi.group77777.exception.CompanyExceptionSymbolExisted;
import com.citi.group77777.model.Company;
import com.citi.group77777.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getAll() {
        return repository.findAll();
    }

    public Company getById(long id) {
        return repository.getById(id);
    }

    public Optional<Company> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id) throws CompanyExceptionNotFound {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new CompanyExceptionNotFound(id);
        }
    }

    public void addOne(Company one) throws CompanyExceptionSymbolExisted {
        List<Company> con1 = repository.getBySymbol(one.getSymbol());
        if (con1.isEmpty()) {
            throw new CompanyExceptionSymbolExisted(one.getSymbol());
        }
        repository.saveAndFlush(one);

    }

    @Transactional
    public void updateOne(long id, Company one) throws CompanyExceptionNotFound {
        Optional<Company> con1 = repository.findById(id);
        if (con1.isEmpty()) {
            throw new CompanyExceptionNotFound(id);
        }

        Company o = con1.get();

        //  check if the property has been changed. refer to default value.
        if (one.getSymbol().length() > 0) {
            o.setSymbol(one.getSymbol());
        }
        if (one.getName().length() > 0) {
            o.setName(one.getName());
        }
        if (one.getIsin().length() > 0) {
            o.setIsin(one.getIsin());
        }
        if (one.getIndustry().length() > 0) {
            o.setIndustry(one.getIndustry());
        }
        if (one.getSeries().length() > 0) {
            o.setSeries(one.getSeries());
        }
    }

    public List<Company> getBySymbol(String symbol) {
        return repository.getBySymbol(symbol);
    }

    public List<Company> getByISIN(String isin) {
        return repository.getByISIN(isin);
    }

    public List<Company> getByName(String name) {
        return repository.getByName(name);
    }
}
