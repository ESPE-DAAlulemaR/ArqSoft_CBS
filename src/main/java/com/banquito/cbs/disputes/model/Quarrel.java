package com.banquito.cbs.disputes.model;

import com.banquito.cbs.transactions.model.Transaction;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "disputa")
public class Quarrel {
    @Id
    @Column
    private Integer id;

    @Column(name = "transaccion_id", nullable = false)
    private Long transactionId;

    @Column(name = "motivo", length = 255, nullable = false)
    private String reason;

    @Column(name = "fecha_disputa", nullable = false)
    private Date quarrelDate;

    @Column(name = "fecha_resolucion", nullable = false)
    private Date resolutionDate;

    @Column(name = "estado", length = 3, nullable = false)
    private String quarrelState;

    @ManyToOne
    @JoinColumn(name = "transaccion_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Transaction transaction;

    public Quarrel() { }

    public Quarrel(Long transactionId, String reason, Date quarrelDate, Date resolutionDate, String quarrelState) {
        this.transactionId = transactionId;
        this.reason = reason;
        this.quarrelDate = quarrelDate;
        this.resolutionDate = resolutionDate;
        this.quarrelState = quarrelState;
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

    public String getQuarrelState() {
        return quarrelState;
    }

    public void setQuarrelState(String quarrelState) {
        this.quarrelState = quarrelState;
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
        return Objects.equals(id, quarrel.id) && Objects.equals(transactionId, quarrel.transactionId) && Objects.equals(reason, quarrel.reason) && Objects.equals(quarrelDate, quarrel.quarrelDate) && Objects.equals(resolutionDate, quarrel.resolutionDate) && Objects.equals(quarrelState, quarrel.quarrelState) && Objects.equals(transaction, quarrel.transaction);
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
                ", quarrelState='" + quarrelState + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
