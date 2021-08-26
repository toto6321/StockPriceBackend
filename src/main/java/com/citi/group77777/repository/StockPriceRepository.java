package com.citi.group77777.repository;

import com.citi.group77777.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {

    @Query(value = "select * from `stock_price` where `symbol` = :symbol ;", nativeQuery = true)
    List<StockPrice> getBySymbol(@Param("symbol") String symbol);

    @Query(value = "select * from `stock_price` where `symbol` = :symbol and `date` between :begin and :end ;", nativeQuery = true)
    List<StockPrice> getBySymbolAndDateRange(@Param("symbol") String symbol, @Param("begin") LocalDate begin, @Param("end") LocalDate end);

    @Query(value = "select * from `stock_price` limit :limit offset :offset ;", nativeQuery = true)
    List<StockPrice> getPage(@Param("limit") int limit, @Param("offset") int offset);

}
