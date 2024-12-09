package com.banquito.cbs.transactions.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;
import java.util.Objects;

public class TransactionDetail {
    @Id
    @Column
    private Integer id;

    @Column(name = "transaccion_id", nullable = false)
    private Long transactionId;

    @Column(name = "tipo_cuenta", length = 3, nullable = false)
    private String accountType;

    @Column(name = "beneficiario", length = 50, nullable = false)
    private String beneficiary;

    @Column(name = "banco", length = 5, nullable = false)
    private String bank;

    @Column(name = "fecha_autorizacion", nullable = false)
    private Date authorisationDate;

    @Column(name = "numero_cuenta", length = 10, nullable = false)
    private String accountNumber;

    @Column(name = "descripcion", length = 50, nullable = false)
    private String description;

    @Column(name = "detalle_json", nullable = true)
    private String jsonDetail;

    @ManyToOne
    @JoinColumn(name = "transaccion_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Transaction transaction;

    public TransactionDetail() { }

    public TransactionDetail(Integer id, Long transactionId, String accountType, String beneficiary, String bank, Date authorisationDate, String accountNumber, String description, String jsonDetail, Transaction transaction) {
        this.id = id;
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.beneficiary = beneficiary;
        this.bank = bank;
        this.authorisationDate = authorisationDate;
        this.accountNumber = accountNumber;
        this.description = description;
        this.jsonDetail = jsonDetail;
        this.transaction = transaction;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Date getAuthorisationDate() {
        return authorisationDate;
    }

    public void setAuthorisationDate(Date authorisationDate) {
        this.authorisationDate = authorisationDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJsonDetail() {
        return jsonDetail;
    }

    public void setJsonDetail(String jsonDetail) {
        this.jsonDetail = jsonDetail;
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
        TransactionDetail that = (TransactionDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(beneficiary, that.beneficiary) && Objects.equals(bank, that.bank) && Objects.equals(authorisationDate, that.authorisationDate) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(description, that.description) && Objects.equals(jsonDetail, that.jsonDetail) && Objects.equals(transaction, that.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId, accountType, beneficiary, bank, authorisationDate, accountNumber, description, jsonDetail, transaction);
    }

    @Override
    public String toString() {
        return "TransactionDetail{" +
                "id=" + id +
                ", transactionId=" + transactionId +
                ", accountType='" + accountType + '\'' +
                ", beneficiary='" + beneficiary + '\'' +
                ", bank='" + bank + '\'' +
                ", authorisationDate=" + authorisationDate +
                ", accountNumber='" + accountNumber + '\'' +
                ", description='" + description + '\'' +
                ", jsonDetail='" + jsonDetail + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
