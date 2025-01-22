// package com.inn.cashflow.server.core.expensehub.entities;

// import java.math.BigDecimal;

// import com.inn.cashflow.server.core.baseimpl.BaseEntity;
// import com.inn.cashflow.server.core.expensehub.enums.AmountType;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "amount_details")
// public class AmountDetails extends BaseEntity {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "original_amount",nullable = false, precision = 15, scale = 2)
//     private BigDecimal originalAmount;

//     @Column(name = "original_currency", nullable = false, length = 3)
//     private String originalCurrency;

//     @Column(name = "converted_amount", precision = 15, scale = 2)
//     private BigDecimal convertedAmount;

//     @Column(name = "base_currency", length = 3)
//     private String baseCurrency;

//     @Column(name = "exchange_rate", precision = 10, scale = 4)
//     private BigDecimal exchangeRate;

//     @Enumerated(EnumType.STRING)
//     @Column(name = "amount_type", nullable = false, length = 20)
//     private AmountType amountType;

//     @Column(name = "tax_amount", precision = 15, scale = 2)
//     private BigDecimal taxAmount;

//     @Column(name = "discount_amount", precision = 15, scale = 2)
//     private BigDecimal discountAmount;

//     @Column(name = "final_amount", precision = 15, scale = 2)
//     private BigDecimal finalAmount;

//     @Column(name = "is_refunded", nullable = false)
//     private Boolean isRefunded;

//     @Column(name = "refund_amount", precision = 15, scale = 2)
//     private BigDecimal refundAmount;

// }
