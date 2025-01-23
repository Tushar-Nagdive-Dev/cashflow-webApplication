package com.inn.cashflow.server.core.incomesource.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.cashflow.server.core.incomesource.entity.IncomeSource;
import com.inn.cashflow.server.core.incomesource.enums.IncomeSourceStatus;


@Repository
public interface IncomeRepository extends JpaRepository<IncomeSource, Long>{
    
    List<IncomeSource> findByStatus(IncomeSourceStatus status);

    boolean existsBySourceName(String sourceName);
}
