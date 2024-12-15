package com.banquito.cbs.transactions.model;

import com.banquito.cbs.financialproducts.model.Account;
import com.banquito.cbs.financialproducts.model.Card;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "transaccion")
public class Transaction implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Long accountId;

    @Column(nullable = true)
    private Long cardId;

    @Column(length = 3, nullable = true)
    private String type;

    @Column(length = 3, nullable = true)
    private String chanel;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Timestamp transactionAt;

    @Column(length = 18, precision = 2, nullable = false)
    private BigDecimal value;

    @Column(length = 18, precision = 2, nullable = false)
    private BigDecimal commission;

    @Column(length = 3, precision = 2, nullable = false)
    private BigDecimal interestRate;

    @Column(nullable = false)
    private Boolean isDeferred;

    @Column(length = 3, nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Timestamp createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "CARD_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Card card;

    public Transaction() { }

    public Transaction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChanel() {
        return chanel;
    }

    public void setChanel(String chanel) {
        this.chanel = chanel;
    }

    public Timestamp getTransactionAt() {
        return transactionAt;
    }

    public void setTransactionAt(Timestamp transactionAt) {
        this.transactionAt = transactionAt;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Boolean getDeferred() {
        return isDeferred;
    }

    public void setDeferred(Boolean deferred) {
        isDeferred = deferred;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", cardId=" + cardId +
                ", type='" + type + '\'' +
                ", chanel='" + chanel + '\'' +
                ", transactionAt=" + transactionAt +
                ", value=" + value +
                ", commission=" + commission +
                ", interestRate=" + interestRate +
                ", isDeferred=" + isDeferred +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
