package com.example.rewards.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@Data
public class Transaction {

    @Id
   private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column (nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate transactionDate;

    public Transaction(Long id,
                       Customer customer,
                      Double amount,
                      LocalDate transactionDate) {
      this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }
}