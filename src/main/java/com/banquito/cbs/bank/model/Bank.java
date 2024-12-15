package com.banquito.cbs.bank.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Bank implements Serializable
{
    @Id
    @Column(length = 5, nullable = false)
    private String bin;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal balance;

    @Column(length = 50, nullable = false)
    private String publicKey;

    @Column(length = 50, nullable = false)
    private String privateKey;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 50, nullable = false)
    private Timestamp updatedAt;

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bin='" + bin + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", publicKey='" + publicKey + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
