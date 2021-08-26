package com.citi.group77777.repository;

import com.citi.group77777.model.StockIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockIndexRepository extends JpaRepository<StockIndex, Long> {

    @Query(value = "select * from stock_index where symbol = ?1 and date between ?2 and ?3", nativeQuery = true)
    List<StockIndex> findBySymbolAndDateRange(String symbol, LocalDate begin, LocalDate end);

    @Query(value = "select * from stock_index limit ?2 offset ?1 ", nativeQuery = true)
    List<StockIndex> getPage(int offset, int limit);
}
