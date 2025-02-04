package com.inn.cashflow.server.core.taxes.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.inn.cashflow.server.core.baseimpl.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tax_payments")
@EqualsAndHashCode(callSuper = false)
public class TaxPayment extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "tax_record_id", nullable = false)
    private TaxRecord taxRecord;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "payment_amount", nullable = false)
    private BigDecimal paymentAmount;

    @Column(name = "receipt_url", length = 255)
    private String receiptUrl;
}
