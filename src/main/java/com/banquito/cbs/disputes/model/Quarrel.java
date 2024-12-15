package com.banquito.cbs.disputes.model;

import com.banquito.cbs.transactions.model.Transaction;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Quarrel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private Long transactionId;

    @Column(length = 255, nullable = false)
    private String reason;

    @Column(nullable = false)
    private Date quarrelDate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date resolutionDate;

    @Column(length = 3, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "TRANSACCION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Transaction transaction;

    public Quarrel() { }

    public Quarrel(Long id) {
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

    public Date getQuarrelDate() {
        return quarrelDate;
    }

    public void setQuarrelDate(Date quarrelDate) {
        this.quarrelDate = quarrelDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
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
        Quarrel quarrel = (Quarrel) o;
        return Objects.equals(id, quarrel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Quarrel{" +
                "id=" + id +
                ", transactionId=" + transactionId +
                ", reason='" + reason + '\'' +
                ", quarrelDate=" + quarrelDate +
                ", resolutionDate=" + resolutionDate +
                ", status='" + status + '\'' +
                '}';
    }
}
