package com.inn.cashflow.server.core.balancedetails.entity;

import java.math.BigDecimal;

import com.inn.cashflow.server.core.balancedetails.enums.BalanceStatus;
import com.inn.cashflow.server.core.baseimpl.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "balance")
public class Balance extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(name = "current_balance", nullable = false, precision = 20, scale = 8)
    private BigDecimal currentBalance;

    @Column(name = "reserved_balance", nullable = false, precision = 20, scale = 8)
    private BigDecimal reservedBalance;

    @Column(name = "total_balance", nullable = false, precision = 20, scale = 8)
    private BigDecimal totalBalance;

    @Column(name = "minimum_balance", nullable = false, precision = 20, scale = 8)
    private BigDecimal minimumBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 10)
    private BalanceStatus status;

    @Column(name = "last_transaction_id")
    private Long lastTransactionId;
}
