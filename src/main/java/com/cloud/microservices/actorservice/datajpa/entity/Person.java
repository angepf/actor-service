package com.cloud.microservices.actorservice.datajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class Person {

    @Id
    @Column(unique = true   )
    private String id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 150)
    private String address;

    @Column(nullable = false, length = 22)
    private String phone;

    @Column(nullable = false, length = 40)
    private String mail;

    @Column(length = 200)
    private String observation;

}
