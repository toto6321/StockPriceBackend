package com.citi.group77777.repository;


import com.citi.group77777.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "select * from stock_market.company where isin = ?1", nativeQuery = true)
    Optional<Company> findByISIN(String isin);

    @Query(value = "select * from stock_market.company where symbol = ?1", nativeQuery = true)
    Optional<Company> findBySymbol(String symbol);
}
