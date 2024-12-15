package com.banquito.cbs.financialproducts.model;

import com.banquito.cbs.customer.model.Customer;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Card implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private Long customerId;

    @Column(length = 255, nullable = false)
    private String number;

    @Column(length = 100, nullable = false)
    private String pin;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(length = 255, nullable = false)
    private String cvv;

    @Column(length = 18, precision = 2, nullable = false)
    private BigDecimal quotaApproved;

    @Column(length = 18, precision = 2, nullable = false)
    private BigDecimal quotaAvailable;

    @Column(nullable = false)
    private Integer cutDay;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date issueDate;

    @Column(length = 3, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Customer customer;

    public Card() {}

    public Card(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getQuotaApproved() {
        return quotaApproved;
    }

    public void setQuotaApproved(BigDecimal quotaApproved) {
        this.quotaApproved = quotaApproved;
    }

    public BigDecimal getQuotaAvailable() {
        return quotaAvailable;
    }

    public void setQuotaAvailable(BigDecimal quotaAvailable) {
        this.quotaAvailable = quotaAvailable;
    }

    public Integer getCutDay() {
        return cutDay;
    }

    public void setCutDay(Integer cutDay) {
        this.cutDay = cutDay;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", number='" + number + '\'' +
                ", pin='" + pin + '\'' +
                ", expirationDate=" + expirationDate +
                ", cvv='" + cvv + '\'' +
                ", quotaApproved=" + quotaApproved +
                ", quotaAvailable=" + quotaAvailable +
                ", cutDay=" + cutDay +
                ", issueDate=" + issueDate +
                ", status='" + status + '\'' +
                '}';
    }
}
