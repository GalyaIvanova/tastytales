package com.example.tastytales.users.module.entities;

import com.example.tastytales.users.module.datatypes.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    //TODO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jwToken;

    @Column(nullable = false)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getJwToken() {
        return jwToken;
    }

    public void setJwToken(String jwToken) {
        this.jwToken=jwToken;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role=role;
    }
}
