package com.doreality.order_management.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "app_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String lastname;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserType userType;

    // Put private fields to dont show them in the response
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    public String getEmail() {
        return email;
    }

}
