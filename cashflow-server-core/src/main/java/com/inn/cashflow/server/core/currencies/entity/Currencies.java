package com.inn.cashflow.server.core.currencies.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.inn.cashflow.server.core.baseimpl.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "currencies")
@EqualsAndHashCode(callSuper = false)
public class Currencies extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_code",nullable = false, length = 3, unique = true)
    private String currencyCode;

    @Column(name = "currency_name",nullable = false, length = 100)
    private String currencyName;

    @Column(length = 10)
    private String symbol;

    @Column(name = "base_currency", length = 3, nullable = false)
    private String baseCurrency;

    @Column(name = "exchange_rate",nullable = false, precision = 10, scale = 4)
    private BigDecimal exchangeRate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(length = 50)
    private String region;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;
}
