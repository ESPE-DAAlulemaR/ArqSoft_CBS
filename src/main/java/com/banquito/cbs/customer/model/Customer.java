package com.banquito.cbs.customer.model;

import com.banquito.cbs.people.model.Enterprise;
import com.banquito.cbs.people.model.Person;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Customer {
    @Id
    @Column
    private Integer id;

    @Column(name = "persona_natural_id", nullable = true)
    private Long personId;

    @Column(name = "persona_juridica_id", nullable = true)
    private Long enterpriseId;

    @Column(name = "tipo_cliente", length = 3, nullable = false)
    private String customerType;

    @Column(name = "fecha_registro", nullable = false)
    private Date registerDate;

    @Column(name = "ingreso_promedio_mes", length = 18, precision = 2, nullable = false)
    private BigDecimal averageMonthlyIncome;

    @ManyToOne
    @JoinColumn(name = "persona_natural_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "persona_juridica_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Enterprise enterprise;

    public Customer() {}

    public Customer(Long personId, Long enterpriseId, String customerType, Date registerDate, BigDecimal averageMonthlyIncome) {
        this.personId = personId;
        this.enterpriseId = enterpriseId;
        this.customerType = customerType;
        this.registerDate = registerDate;
        this.averageMonthlyIncome = averageMonthlyIncome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return Objects.equals(id, customer.id) && Objects.equals(personId, customer.personId) && Objects.equals(enterpriseId, customer.enterpriseId) && Objects.equals(customerType, customer.customerType) && Objects.equals(registerDate, customer.registerDate) && Objects.equals(averageMonthlyIncome, customer.averageMonthlyIncome) && Objects.equals(person, customer.person) && Objects.equals(enterprise, customer.enterprise);
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
                ", person=" + person +
                ", enterprise=" + enterprise +
                '}';
    }
}
