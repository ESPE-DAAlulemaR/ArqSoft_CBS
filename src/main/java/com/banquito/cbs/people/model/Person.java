package com.banquito.cbs.people.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "persona_natural")
public class Person {
    @Id
    @Column
    private Integer id;

    @Column(name = "tipo_identificacion", length = 3, nullable = false)
    private String identificationType;

    @Column(name = "identificacion", length = 13, nullable = false)
    private String identification;

    @Column(name = "primer_nombre", length = 32, nullable = false)
    private String firstName;

    @Column(name = "segundo_nombre", length = 32, nullable = false)
    private String secondName;

    @Column(name = "primer_apellido", length = 32, nullable = false)
    private String firstLastName;

    @Column(name = "segundo_apellido", length = 32, nullable = false)
    private String secondLastName;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "telefono", length = 10, nullable = false)
    private String phoneNumber;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date birthDate;

    public Person() { }

    public Person(Integer id, String identification, String identificationType, String firstName, String secondName, String firstLastName, String secondLastName, String email, String phoneNumber, Date birthDate) {
        this.id = id;
        this.identification = identification;
        this.identificationType = identificationType;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(identificationType, person.identificationType) && Objects.equals(identification, person.identification) && Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName) && Objects.equals(firstLastName, person.firstLastName) && Objects.equals(secondLastName, person.secondLastName) && Objects.equals(email, person.email) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", identificationType='" + identificationType + '\'' +
                ", identification='" + identification + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", firstLastName='" + firstLastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
