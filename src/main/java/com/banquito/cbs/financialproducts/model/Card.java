package com.banquito.cbs.financialproducts.model;

import com.banquito.cbs.customer.model.Customer;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tarjeta")
public class Card {
    @Id
    @Column
    private Integer id;

    @Column(name = "cliente_id", nullable = false)
    private Long customerId;

    @Column(name = "numero", length = 255, nullable = false)
    private String number;

    @Column(name = "pin", length = 100, nullable = false)
    private String pin;

    @Column(name = "facha_caducidad", nullable = false)
    private Date expirationDate;

    @Column(name = "cvv", length = 255, nullable = false)
    private String cvv;

    @Column(name = "cupo_aprobado", length = 18, precision = 2, nullable = false)
    private BigDecimal quotaApproved;

    @Column(name = "cupo_disponible", length = 18, precision = 2, nullable = false)
    private BigDecimal quotaAvailable;

    @Column(name = "dia_corte", nullable = false)
    private Integer cutDay;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;

    public Card() {}

    public Card(Long customerId, String number, String pin, Date expirationDate, String cvv, BigDecimal quotaApproved, BigDecimal quotaAvailable, Integer cutDay) {
        this.customerId = customerId;
        this.number = number;
        this.pin = pin;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.quotaApproved = quotaApproved;
        this.quotaAvailable = quotaAvailable;
        this.cutDay = cutDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return Objects.equals(id, card.id) && Objects.equals(customerId, card.customerId) && Objects.equals(number, card.number) && Objects.equals(pin, card.pin) && Objects.equals(expirationDate, card.expirationDate) && Objects.equals(cvv, card.cvv) && Objects.equals(quotaApproved, card.quotaApproved) && Objects.equals(quotaAvailable, card.quotaAvailable) && Objects.equals(cutDay, card.cutDay) && Objects.equals(customer, card.customer);
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
                ", customer=" + customer +
                '}';
    }
}
