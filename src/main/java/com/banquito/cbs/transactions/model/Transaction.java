package com.banquito.cbs.transactions.model;

import com.banquito.cbs.financialproducts.model.Account;
import com.banquito.cbs.financialproducts.model.Card;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "transaccion")
public class Transaction {
    @Id
    @Column
    private Integer id;

    @Column(name = "cuenta_id", nullable = true)
    private Long accountId;

    @Column(name = "tarjeta_id", nullable = true)
    private Long cardId;

    @Column
    private String transactionType;

    @Column
    private String transactionChanel;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Timestamp transactionDate;

    @Column(name = "valor", length = 18, precision = 2, nullable = false)
    private BigDecimal value;

    @Column(name = "comision", length = 18, precision = 2, nullable = false)
    private BigDecimal comision;

    @Column(name = "interes", length = 3, precision = 2, nullable = false)
    private BigDecimal interest;

    @Column(name = "es_diferido", nullable = false)
    private Boolean isDeferred;

    @Column(name = "estado", length = 3, nullable = false)
    private String transactionState;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "tarjeta_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Card card;

    public Transaction() { }

    public Transaction(Long accountId, Long cardId, String transactionType, String transactionChanel, Timestamp transactionDate, BigDecimal value, BigDecimal comision, Boolean isDeferred, BigDecimal interest, String transactionState) {
        this.accountId = accountId;
        this.cardId = cardId;
        this.transactionType = transactionType;
        this.transactionChanel = transactionChanel;
        this.transactionDate = transactionDate;
        this.value = value;
        this.comision = comision;
        this.isDeferred = isDeferred;
        this.interest = interest;
        this.transactionState = transactionState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionChanel() {
        return transactionChanel;
    }

    public void setTransactionChanel(String transactionChanel) {
        this.transactionChanel = transactionChanel;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Boolean getDeferred() {
        return isDeferred;
    }

    public void setDeferred(Boolean deferred) {
        isDeferred = deferred;
    }

    public String getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(String transactionState) {
        this.transactionState = transactionState;
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
        return Objects.equals(id, that.id) && Objects.equals(accountId, that.accountId) && Objects.equals(cardId, that.cardId) && Objects.equals(transactionType, that.transactionType) && Objects.equals(transactionChanel, that.transactionChanel) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(value, that.value) && Objects.equals(comision, that.comision) && Objects.equals(interest, that.interest) && Objects.equals(isDeferred, that.isDeferred) && Objects.equals(transactionState, that.transactionState) && Objects.equals(account, that.account) && Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", cardId=" + cardId +
                ", transactionType='" + transactionType + '\'' +
                ", transactionChanel='" + transactionChanel + '\'' +
                ", transactionDate=" + transactionDate +
                ", value=" + value +
                ", comision=" + comision +
                ", interest=" + interest +
                ", isDeferred=" + isDeferred +
                ", transactionState='" + transactionState + '\'' +
                ", account=" + account +
                ", card=" + card +
                '}';
    }
}
