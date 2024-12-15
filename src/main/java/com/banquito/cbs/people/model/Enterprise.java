package com.banquito.cbs.people.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Enterprise implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long personId;

    @Column(length = 13, nullable = false)
    private String ruc;

    @Column(length = 100, nullable = false)
    private String bussinessName;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 10, nullable = false)
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date incorporationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Timestamp registerAt;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID", updatable = false, insertable = false)
    private Person person;

    public Enterprise() { }

    public Enterprise(Long id) {
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getIncorporationDate() {
        return incorporationDate;
    }

    public void setIncorporationDate(Date incorporationDate) {
        this.incorporationDate = incorporationDate;
    }

    public Timestamp getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Timestamp registerAt) {
        this.registerAt = registerAt;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enterprise that = (Enterprise) o;
        return Objects.equals(ruc, that.ruc);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ruc);
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", personId=" + personId +
                ", ruc='" + ruc + '\'' +
                ", bussinessName='" + bussinessName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", incorporationDate=" + incorporationDate +
                ", registerAt=" + registerAt +
                '}';
    }
}
