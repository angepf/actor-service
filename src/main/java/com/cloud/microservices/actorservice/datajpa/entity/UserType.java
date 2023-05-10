package com.cloud.microservices.actorservice.datajpa.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SuperBuilder
public class UserType {

    @Id
    @SequenceGenerator(name = "seqUserType", initialValue = 4   )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUserType")
    private Integer id;

    @Column(nullable = false, length = 15)
    private String description;

}
