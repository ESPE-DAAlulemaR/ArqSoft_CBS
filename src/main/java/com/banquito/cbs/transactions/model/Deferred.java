package com.banquito.cbs.transactions.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Deferred implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long transactionId;

    @Column(nullable = false)
    private Integer quotas;

    @Column(nullable = false)
    private Integer cancelledQuotas;

    @Column(precision = 3, scale = 2, nullable = false)
    private BigDecimal interestRate;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal quoteValue;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal debtValue;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal remainingValue;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal interestValue;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Transaction transaction;

    public Deferred() {}

    public Deferred(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getQuotas() {
        return quotas;
    }

    public void setQuotas(Integer quotas) {
        this.quotas = quotas;
    }

    public Integer getCancelledQuotas() {
        return cancelledQuotas;
    }

    public void setCancelledQuotas(Integer cancelledQuotas) {
        this.cancelledQuotas = cancelledQuotas;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getQuoteValue() {
        return quoteValue;
    }

    public void setQuoteValue(BigDecimal quoteValue) {
        this.quoteValue = quoteValue;
    }

    public BigDecimal getDebtValue() {
        return debtValue;
    }

    public void setDebtValue(BigDecimal debtValue) {
        this.debtValue = debtValue;
    }

    public BigDecimal getRemainingValue() {
        return remainingValue;
    }

    public void setRemainingValue(BigDecimal remainingValue) {
        this.remainingValue = remainingValue;
    }

    public BigDecimal getInterestValue() {
        return interestValue;
    }

    public void setInterestValue(BigDecimal interestValue) {
        this.interestValue = interestValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deferred deferred = (Deferred) o;
        return Objects.equals(id, deferred.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Deferred{" +
                "id=" + id +
                ", transactionId=" + transactionId +
                ", quotas=" + quotas +
                ", cancelledQuotas=" + cancelledQuotas +
                ", interestRate=" + interestRate +
                ", amount=" + amount +
                ", quoteValue=" + quoteValue +
                ", debtvalue=" + debtValue +
                ", remainingValue=" + remainingValue +
                ", interestValue=" + interestValue +
                ", status='" + status + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
