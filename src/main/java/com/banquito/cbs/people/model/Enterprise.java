package com.banquito.cbs.people.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;
import java.util.Objects;

public class Enterprise {
    @Id
    @Column
    private Integer id;

    @Column(name = "persona_natural_id", nullable = false)
    private Long personId;

    @Column(name = "ruc", length = 13, nullable = false)
    private String ruc;

    @Column(name = "razon_social", length = 40, nullable = false)
    private String bussinessName;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "telefono", length = 10, nullable = false)
    private String phoneNumber;

    @Column(name = "fecha_constitucion", nullable = false)
    private Date incorporationDate;

    @Column(name = "fecha_registro", nullable = false)
    private Date registerDate;

    @ManyToOne
    @JoinColumn(name = "persona_natural_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Person person;

    public Enterprise() { }

    public Enterprise(Integer id, Long personId, String ruc, String bussinessName, String email, String phoneNumber, Date incorporationDate, Date registerDate, Person person) {
        this.id = id;
        this.personId = personId;
        this.ruc = ruc;
        this.bussinessName = bussinessName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.incorporationDate = incorporationDate;
        this.registerDate = registerDate;
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enterprise that = (Enterprise) o;
        return Objects.equals(id, that.id) && Objects.equals(personId, that.personId) && Objects.equals(ruc, that.ruc) && Objects.equals(bussinessName, that.bussinessName) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(incorporationDate, that.incorporationDate) && Objects.equals(registerDate, that.registerDate) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
                ", registerDate=" + registerDate +
                ", person=" + person +
                '}';
    }
}
