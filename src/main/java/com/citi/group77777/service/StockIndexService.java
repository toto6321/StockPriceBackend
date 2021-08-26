package com.citi.group77777.service;

import com.citi.group77777.exception.StockIndexExceptionNotFound;
import com.citi.group77777.exception.StockIndexExceptionSymbolAndDateExisted;
import com.citi.group77777.model.StockIndex;
import com.citi.group77777.repository.StockIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockIndexService {

    private final StockIndexRepository repository;

    @Autowired
    public StockIndexService(StockIndexRepository repo) {
        this.repository = repo;
    }

    public List<StockIndex> getAll() {
        return repository.findAll();
    }

    public List<StockIndex> getAllByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    public StockIndex getById(long id) {
        return repository.getById(id);
    }

    public Optional<StockIndex> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) throws StockIndexExceptionNotFound {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new StockIndexExceptionNotFound(id);
        }
    }

    public void addOne(StockIndex one) throws StockIndexExceptionSymbolAndDateExisted {
        List<StockIndex> con1 = repository.getBySymbolAndDateRange(one.getSymbol(), one.getDate(), one.getDate());
        if (!con1.isEmpty()) {
            throw new StockIndexExceptionSymbolAndDateExisted(one.getSymbol(), one.getDate());
        }
        repository.saveAndFlush(one);

    }

    @Transactional
    public void updateOne(long id, StockIndex one) throws StockIndexExceptionNotFound {
        Optional<StockIndex> con1 = repository.findById(id);
        if (con1.isEmpty()) {
            throw new StockIndexExceptionNotFound(id);
        }

        StockIndex o = con1.get();

        //  check if the property has been changed. refer to default value.
        if (one.getSymbol().length() > 0) {
            o.setSymbol(one.getSymbol());
        }
        if (one.getOpen() > 0) {
            o.setOpen(one.getOpen());
        }
        if (one.getHigh() > 0) {
            o.setHigh(one.getHigh());
        }
        if (one.getClose() > 0) {
            o.setClose(one.getClose());
        }
        if (one.getLow() > 0) {
            o.setLow(one.getLow());
        }
        if (one.getVolume() > 0) {
            o.setVolume(one.getVolume());
        }
    }

    public List<StockIndex> getPage(int pageSize, int page) {
        return repository.getPage(pageSize, pageSize * (page - 1));
    }

    public List<StockIndex> getBySymbol(String symbol) {
        return repository.getBySymbol(symbol);
    }

    public List<StockIndex> getBySymbolAndDateRange(String symbol, LocalDate begin, LocalDate end) {
        return repository.getBySymbolAndDateRange(symbol, begin, end);
    }
}
