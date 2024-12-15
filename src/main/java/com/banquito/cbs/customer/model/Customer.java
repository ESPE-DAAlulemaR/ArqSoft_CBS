package com.banquito.cbs.customer.model;

import com.banquito.cbs.people.model.Enterprise;
import com.banquito.cbs.people.model.Person;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Customer implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = true)
    private Long personId;

    @Column(nullable = true)
    private Long enterpriseId;

    @Column(length = 3, nullable = false)
    private String customerType;

    @Column(nullable = false)
    private Date registerDate;

    @Column(length = 18, precision = 2, nullable = false)
    private BigDecimal averageMonthlyIncome;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "ENTERPRISE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Enterprise enterprise;

    public Customer() {}

    public Customer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public BigDecimal getAverageMonthlyIncome() {
        return averageMonthlyIncome;
    }

    public void setAverageMonthlyIncome(BigDecimal averageMonthlyIncome) {
        this.averageMonthlyIncome = averageMonthlyIncome;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", personId=" + personId +
                ", enterpriseId=" + enterpriseId +
                ", customerType='" + customerType + '\'' +
                ", registerDate=" + registerDate +
                ", averageMonthlyIncome=" + averageMonthlyIncome +
                '}';
    }
}
