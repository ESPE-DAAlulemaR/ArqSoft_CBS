package com.banquito.cbs.financialproducts.model;

import com.banquito.cbs.customer.model.Customer;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cuenta")
public class Account {
    @Id
    @Column
    private Integer id;

    @Column(name = "cliente_id", nullable = false)
    private Long customerId;

    @Column(name = "tipo_cuenta", length = 3, nullable = false)
    private String type;

    @Column(name = "number", length = 10, nullable = false)
    private String number;

    @Column(name = "saldo_total", length = 18, precision = 2, nullable = false)
    private BigDecimal totalBalance;

    @Column(name = "saldo_disponible", length = 18, precision = 2, nullable = false)
    private BigDecimal availableBalance;

    @Column(name = "estado", length = 3, nullable = false)
    private String accountState;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;

    public Account() { }

    public Account(String type, String number, BigDecimal totalBalance, BigDecimal availableBalance, String accountState, Long customerId) {
        this.type = type;
        this.number = number;
        this.totalBalance = totalBalance;
        this.availableBalance = availableBalance;
        this.accountState = accountState;
        this.customerId = customerId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
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
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(customerId, account.customerId) && Objects.equals(type, account.type) && Objects.equals(number, account.number) && Objects.equals(totalBalance, account.totalBalance) && Objects.equals(availableBalance, account.availableBalance) && Objects.equals(accountState, account.accountState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", totalBalance=" + totalBalance +
                ", availableBalance=" + availableBalance +
                ", accountState='" + accountState + '\'' +
                '}';
    }
}
