package com.inn.cashflow.server.core.taxes.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.inn.cashflow.server.core.baseimpl.BaseEntity;
import com.inn.cashflow.server.core.taxes.enums.TaxRecordStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "tax_records") 
@EqualsAndHashCode(callSuper = false)
public class TaxRecord extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "tax_category_id", nullable = false)
    private TaxCategories taxCategory;

    @Column(name = "taxable_amount", nullable = false)
    private BigDecimal taxableAmount;

    @Column(name = "tax_amount", nullable = false)
    private BigDecimal taxAmount;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private TaxRecordStatus status;
    
}
