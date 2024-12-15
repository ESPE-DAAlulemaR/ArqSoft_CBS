package com.banquito.cbs.auth.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3, nullable = false)
    private String role;

    @Column(length = 32, nullable = false)
    private String username;

    @Column(length = 256, nullable = false)
    private String password;

    @Column(length = 3, nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private String lastLogin;

    @Temporal(TemporalType.TIMESTAMP)
    private String createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private String updatedAt;

    public User() { }

    public User(Long id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
