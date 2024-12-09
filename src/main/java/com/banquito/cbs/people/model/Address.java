package com.banquito.cbs.people.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="direccion")
public class Address implements Serializable {
    @Id
    @Column
    private Integer id;

    @Column(name = "persona_natural_id", nullable = true)
    private Long personId;

    @Column(name = "persona_juridica_id", nullable = true)
    private Long enterpriseId;

    @Column(name = "ciudad", length = 32, nullable = false)
    private String city;

    @Column(name = "provincia", length = 32, nullable = false)
    private String state;

    @Column(name = "canton", length = 32, nullable = false)
    private String canton;

    @Column(name = "sector", length = 32, nullable = false)
    private String sector;

    @Column(name = "calle_principal", length = 64, nullable = false)
    private String principalStreet;

    @Column(name = "calle_secundaria", length = 64, nullable = false)
    private String secondaryStreet;

    @Column(name = "numeracion", length = 16, nullable = false)
    private String number;

    @Column(name = "referencia", length = 64, nullable = false)
    private String reference;

    @Column(name = "detalle_adicional", length = 100, nullable = false)
    private String detail;

    @ManyToOne
    @JoinColumn(name = "persona_natural_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "persona_juridica_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Enterprise enterprise;

    public Address() {}

    public Address(String detail, String reference, String number, String secondaryStreet, String principalStreet, String sector, String canton, String state, String city, Long enterpriseId, Long personId) {
        this.detail = detail;
        this.reference = reference;
        this.number = number;
        this.secondaryStreet = secondaryStreet;
        this.principalStreet = principalStreet;
        this.sector = sector;
        this.canton = canton;
        this.state = state;
        this.city = city;
        this.enterpriseId = enterpriseId;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        return Objects.equals(id, address.id) && Objects.equals(personId, address.personId) && Objects.equals(enterpriseId, address.enterpriseId) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(canton, address.canton) && Objects.equals(sector, address.sector) && Objects.equals(principalStreet, address.principalStreet) && Objects.equals(secondaryStreet, address.secondaryStreet) && Objects.equals(number, address.number) && Objects.equals(reference, address.reference) && Objects.equals(detail, address.detail) && Objects.equals(person, address.person) && Objects.equals(enterprise, address.enterprise);
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
                ", state='" + state + '\'' +
                ", canton='" + canton + '\'' +
                ", sector='" + sector + '\'' +
                ", principalStreet='" + principalStreet + '\'' +
                ", secondaryStreet='" + secondaryStreet + '\'' +
                ", number='" + number + '\'' +
                ", reference='" + reference + '\'' +
                ", detail='" + detail + '\'' +
                ", person=" + person +
                ", enterprise=" + enterprise +
                '}';
    }
}
