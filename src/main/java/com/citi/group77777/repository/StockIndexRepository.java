package com.citi.group77777.repository;

import com.citi.group77777.model.StockIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockIndexRepository extends JpaRepository<StockIndex, Long> {

    @Query(value = "select * from `stock_index` where `symbol` = :symbol ;", nativeQuery = true)
    List<StockIndex> getBySymbol(@Param("symbol") String symbol);

    @Query(value = "select * from `stock_index` where `symbol` = :symbol and `date` between :begin and :end ;", nativeQuery = true)
    List<StockIndex> getBySymbolAndDateRange(@Param("symbol") String symbol, @Param("begin") LocalDate begin, @Param("end") LocalDate end);

    @Query(value = "select * from `stock_index` limit :limit offset :offset ;", nativeQuery = true)
    List<StockIndex> getPage(@Param("limit") int limit, @Param("offset") int offset);

    @Query(value = "select * from `stock_index` where `date` between :begin and :end order by `symbol`, `date` ;", nativeQuery = true)
    List<StockIndex> getAllWithinPeriod(@Param("begin") LocalDate begin, @Param("end") LocalDate end);
}
