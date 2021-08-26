package com.citi.group77777.repository;


import com.citi.group77777.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "select * from `company` where `isin` = :isin ;", nativeQuery = true)
    Optional<Company> findByISIN(@Param("isin") String isin);

    @Query(value = "select * from `company` where `symbol` = :symbol ;", nativeQuery = true)
    Optional<Company> findBySymbol(@Param("symbol") String symbol);
}
