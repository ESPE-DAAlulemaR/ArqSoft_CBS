package com.banquito.cbs.people.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Long personId;

    @Column(nullable = true)
    private Long enterpriseId;

    @Column(length = 32, nullable = false)
    private String city;

    @Column(length = 32, nullable = false)
    private String province;

    @Column(length = 32, nullable = false)
    private String canton;

    @Column(length = 32, nullable = false)
    private String sector;

    @Column(length = 64, nullable = false)
    private String principalStreet;

    @Column(length = 64, nullable = false)
    private String secondaryStreet;

    @Column(length = 16, nullable = false)
    private String number;

    @Column(length = 64, nullable = false)
    private String reference;

    @Column(length = 100, nullable = true)
    private String detail;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "ENTERPRISE_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Enterprise enterprise;

    public Address() {}

    public Address(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getPrincipalStreet() {
        return principalStreet;
    }

    public void setPrincipalStreet(String principalStreet) {
        this.principalStreet = principalStreet;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSecondaryStreet() {
        return secondaryStreet;
    }

    public void setSecondaryStreet(String secondaryStreet) {
        this.secondaryStreet = secondaryStreet;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", personId=" + personId +
                ", enterpriseId=" + enterpriseId +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", canton='" + canton + '\'' +
                ", sector='" + sector + '\'' +
                ", principalStreet='" + principalStreet + '\'' +
                ", secondaryStreet='" + secondaryStreet + '\'' +
                ", number='" + number + '\'' +
                ", reference='" + reference + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
