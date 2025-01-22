package com.inn.cashflow.server.core.currencies.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.cashflow.server.core.currencies.entity.Currencies;

@Repository
public interface CurrencyRepository extends JpaRepository<Currencies, Long>{
    
}
