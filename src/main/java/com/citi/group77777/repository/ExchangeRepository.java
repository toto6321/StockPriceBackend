package com.citi.group77777.repository;


import com.citi.group77777.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    @Query(value = "select * from `exchange` where `symbol` like concat('%',:symbol,'%') ;", nativeQuery = true)
    List<Exchange> getBySymbol(@Param("symbol") String symbol);

    @Query(value = "select * from `exchange` where `name` like concat('%',:name,'%') ;", nativeQuery = true)
    List<Exchange> getByName(@Param("name") String name);

}
