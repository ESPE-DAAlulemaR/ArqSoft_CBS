package com.banquito.cbs.transactions.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.Objects;

public class Deferred {
    @Id
    @Column
    private Integer id;

    @Column(name = "transaccion_id", nullable = false)
    private Long transactionId;

    @Column(name = "cuotas")
    private Integer quotas;

    @Column(name = "cuotas_canceladas")
    private Integer cancelledQuotas;

    @Column(name = "porcentaje_interes")
    private BigDecimal interestRate;

    @Column(name = "monto")
    private BigDecimal amount;

    @Column(name = "valor_cuota")
    private BigDecimal quoteValue;

    @Column(name = "valor_deuda")
    private BigDecimal debtvalue;

    @Column(name = "valor_deuda")
    private BigDecimal remainingValue;

    @Column(name = "valor_interes")
    private BigDecimal interestValue;

    @Column(name = "estado")
    private String deferredState;

    @ManyToOne
    @JoinColumn(name = "transaccion_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Transaction transaction;

    public Deferred() {}

    public Deferred(Long transactionId, Integer quotas, Integer cancelledQuotas, BigDecimal interestRate, BigDecimal amount, BigDecimal quoteValue, BigDecimal debtvalue, BigDecimal remainingValue, BigDecimal interestValue, String deferredState) {
        this.transactionId = transactionId;
        this.quotas = quotas;
        this.cancelledQuotas = cancelledQuotas;
        this.interestRate = interestRate;
        this.amount = amount;
        this.quoteValue = quoteValue;
        this.debtvalue = debtvalue;
        this.remainingValue = remainingValue;
        this.interestValue = interestValue;
        this.deferredState = deferredState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public BigDecimal getDebtvalue() {
        return debtvalue;
    }

    public void setDebtvalue(BigDecimal debtvalue) {
        this.debtvalue = debtvalue;
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

    public String getDeferredState() {
        return deferredState;
    }

    public void setDeferredState(String deferredState) {
        this.deferredState = deferredState;
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
        return Objects.equals(id, deferred.id) && Objects.equals(transactionId, deferred.transactionId) && Objects.equals(quotas, deferred.quotas) && Objects.equals(cancelledQuotas, deferred.cancelledQuotas) && Objects.equals(interestRate, deferred.interestRate) && Objects.equals(amount, deferred.amount) && Objects.equals(quoteValue, deferred.quoteValue) && Objects.equals(debtvalue, deferred.debtvalue) && Objects.equals(remainingValue, deferred.remainingValue) && Objects.equals(interestValue, deferred.interestValue) && Objects.equals(deferredState, deferred.deferredState) && Objects.equals(transaction, deferred.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
                ", debtvalue=" + debtvalue +
                ", remainingValue=" + remainingValue +
                ", interestValue=" + interestValue +
                ", deferredState='" + deferredState + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
