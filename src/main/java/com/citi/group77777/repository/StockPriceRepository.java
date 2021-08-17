package com.citi.group77777.repository;

import com.citi.group77777.dto.StockPriceGroupBySymbolwithAvg;
import com.citi.group77777.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {

    @Query(value = "select * from stock_market.stock_price where symbol = ?1 and date = ?2", nativeQuery = true)
    Optional<StockPrice> findBySymbolAndDate(String symbol, LocalDate date);

    @Query(value = "select * from stock_price limit ?2 offset ?1 ", nativeQuery = true)
    List<StockPrice> getPage(int offset, int limit);

    @Query(value = "select symbol, avg(open), avg(high), avg(low), avg(close), avg(volume) from stock_price group by symbol; ", nativeQuery = true)
    List<StockPriceGroupBySymbolwithAvg> getAVG();
}
