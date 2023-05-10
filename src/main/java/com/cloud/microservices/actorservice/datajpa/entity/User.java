package com.cloud.microservices.actorservice.datajpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "USERS")
public class User extends Person {

    @Column(nullable = false, length = 23)
    private String username;

    @Column(nullable = false, length = 24)
    private String password;

    @ManyToOne
    @JoinColumn(name = "userType", nullable = false)
    private UserType userType;

    @Column(nullable = false)
    private boolean status;

}
