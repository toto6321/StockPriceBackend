package com.citi.group77777.service;

import com.citi.group77777.exception.ExchangeExceptionNotFound;
import com.citi.group77777.exception.ExchangeExceptionSymbolExisted;
import com.citi.group77777.model.Exchange;
import com.citi.group77777.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ExchangeService {

    private final ExchangeRepository repository;

    @Autowired
    public ExchangeService(ExchangeRepository repository) {
        this.repository = repository;
    }

    public List<Exchange> getAll() {
        return repository.findAll();
    }

    public Exchange getById(long id) {
        return repository.getById(id);
    }

    public Optional<Exchange> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id) throws ExchangeExceptionNotFound {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ExchangeExceptionNotFound(id);
        }
    }

    public void addOne(Exchange one) throws ExchangeExceptionSymbolExisted {
        List<Exchange> con1 = repository.getBySymbol(one.getSymbol());
        if (con1.isEmpty()) {
            throw new ExchangeExceptionSymbolExisted(one.getSymbol());
        }
        repository.saveAndFlush(one);

    }

    @Transactional
    public void updateOne(long id, Exchange one) throws ExchangeExceptionNotFound {
        Optional<Exchange> con1 = repository.findById(id);
        if (con1.isEmpty()) {
            throw new ExchangeExceptionNotFound(id);
        }

        Exchange o = con1.get();

        //  check if the property has been changed. refer to default value.
        if (one.getSymbol().length() > 0) {
            o.setSymbol(one.getSymbol());
        }
        if (one.getName().length() > 0) {
            o.setName(one.getName());
        }
        if (one.getRegion().length() > 0) {
            o.setRegion(one.getRegion());
        }
        if (one.getCurrency().length() > 0) {
            o.setCurrency(one.getCurrency());
        }
    }

    public List<Exchange> getBySymbol(String symbol) {
        return repository.getBySymbol(symbol);
    }

    public List<Exchange> getByName(String name) {
        return repository.getByName(name);
    }

}
