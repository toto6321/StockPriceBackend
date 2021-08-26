package com.citi.group77777.repository;


import com.citi.group77777.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "select * from `company` where `isin` like concat('%',:isin,'%')", nativeQuery = true)
    List<Company> getByISIN(@Param("isin") String isin);

    @Query(value = "select * from `company` where `symbol` like concat('%',:symbol,'%') ;", nativeQuery = true)
    List<Company> getBySymbol(@Param("symbol") String symbol);

    @Query(value = "select * from `company` where `name` like concat('%',:name,'%') ;", nativeQuery = true)
    List<Company> getByName(@Param("name") String name);

}
