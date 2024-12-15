package com.banquito.cbs.transactions.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

public class TransactionDetail {
    @Id
    @Column(nullable = false)
    private Long transactionId;

    @Column(length = 3, nullable = false)
    private String accountType;

    @Column(length = 50, nullable = false)
    private String beneficiary;

    @Column(length = 5, nullable = false)
    private String sourceBankBin;

    @Column(length = 5, nullable = false)
    private String destinationBankBin;

    @Column(nullable = false)
    private Date authorisationAt;

    @Column(length = 10, nullable = false)
    private String accountNumber;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(nullable = true)
    private String jsonDetail;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Transaction transaction;

    public TransactionDetail() { }

    public TransactionDetail(Long transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDetail that = (TransactionDetail) o;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(transactionId);
    }
}
