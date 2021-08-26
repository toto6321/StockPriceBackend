package com.citi.group77777.service;

import com.citi.group77777.exception.StockPriceExceptionNotFound;
import com.citi.group77777.exception.StockPriceExceptionSymbolAndDateExisted;
import com.citi.group77777.model.StockPrice;
import com.citi.group77777.repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockPriceService {

    private final StockPriceRepository repository;

    @Autowired
    public StockPriceService(StockPriceRepository repo) {
        this.repository = repo;
    }

    public List<StockPrice> getAll() {
        return repository.findAll();
    }

    public List<StockPrice> getAllByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    public StockPrice getById(long id) {
        return repository.getById(id);
    }

    public Optional<StockPrice> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) throws StockPriceExceptionNotFound {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new StockPriceExceptionNotFound(id);
        }
    }

    public void addOne(StockPrice one) throws StockPriceExceptionSymbolAndDateExisted {
        List<StockPrice> con1 = repository.getBySymbolAndDateRange(one.getSymbol(), one.getDate(), one.getDate());
        if (!con1.isEmpty()) {
            throw new StockPriceExceptionSymbolAndDateExisted(one.getSymbol(), one.getDate());
        }
        repository.saveAndFlush(one);

    }

    @Transactional
    public void updateOne(long id, StockPrice one) throws StockPriceExceptionNotFound {
        Optional<StockPrice> con1 = repository.findById(id);
        if (con1.isEmpty()) {
            throw new StockPriceExceptionNotFound(id);
        }

        StockPrice o = con1.get();

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

    public List<StockPrice> getPage(int pageSize, int page) {
        return repository.getPage(pageSize, pageSize * (page - 1));
    }

    public List<StockPrice> getBySymbol(String symbol) {
        return repository.getBySymbol(symbol);
    }

    public List<StockPrice> getBySymbolAndDateRange(String symbol, LocalDate begin, LocalDate end) {
        return repository.getBySymbolAndDateRange(symbol, begin, end);
    }

}
