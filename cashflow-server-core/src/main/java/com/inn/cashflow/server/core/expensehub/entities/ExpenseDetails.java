// package com.inn.cashflow.server.core.expensehub.entities;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.time.LocalDateTime;

// import com.inn.cashflow.server.core.baseimpl.BaseEntity;
// import com.inn.cashflow.server.core.expensehub.enums.ExpenseStatus;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "expense_details")
// public class ExpenseDetails extends BaseEntity{
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "user_id",nullable = false)
//     private Long userId;

//     @Column(nullable = false, length = 100)
//     private String title;

//     @Column(columnDefinition = "TEXT")
//     private String description;

//     @Column(nullable = false, precision = 15, scale = 2)
//     private BigDecimal amount;

//     @Column(nullable = false, length = 3)
//     private String currency;

//     @Column(name = "category_id",nullable = false)
//     private Long categoryId;

//     @Column(name = "sub_category_id")
//     private Long subCategoryId;

//     @Column(name = "payement_method",nullable = false, length = 50)
//     private String paymentMethod;

//     @Column(name = "transaction_id",length = 100)
//     private String transactionId;

//     @Column(name = "expense_date",nullable = false)
//     private LocalDate expenseDate;

//     @Column(name = "entry_date",nullable = false)
//     private LocalDateTime entryDate;

//     @Column(name= "is_recurring",nullable = false)
//     private Boolean isRecurring;

//     @Column(name = "attachment_url",length = 255)
//     private String attachmentUrl;

//     @Column(columnDefinition = "json")
//     private String tags;

//     @Enumerated(EnumType.STRING)
//     @Column(nullable = false, length = 20)
//     private ExpenseStatus status;

//     @Column(nullable = false)
//     private Boolean isTaxDeductible;

//     @Column(nullable = false)
//     private Boolean isReimbursable;
// }
