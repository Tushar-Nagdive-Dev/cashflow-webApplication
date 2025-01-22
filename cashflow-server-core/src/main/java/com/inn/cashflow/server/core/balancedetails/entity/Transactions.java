package com.inn.cashflow.server.core.balancedetails.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.inn.cashflow.server.core.balancedetails.enums.TransactionStatus;
import com.inn.cashflow.server.core.balancedetails.enums.TransactionType;
import com.inn.cashflow.server.core.baseimpl.BaseEntity;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "transactions")
public class Transactions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "balance_id")
    private Balance balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type",nullable = false, length = 20)
    private TransactionType transactionType;

    @Column(nullable = false, precision = 20, scale = 8)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(name = "exchange_rate",precision = 10, scale = 4)
    private BigDecimal exchangeRate;

    @Column(name = "reference_id", length = 100)
    private String referenceId;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TransactionStatus status;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "related_transaction_id")
    private Long relatedTransactionId;
}
