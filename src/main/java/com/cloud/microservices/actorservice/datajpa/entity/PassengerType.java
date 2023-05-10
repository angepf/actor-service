package com.cloud.microservices.actorservice.datajpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SuperBuilder
public class PassengerType {

    @Id
    @SequenceGenerator(name = "seqPassengerType", initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassengerType")
    private Integer id;

    @Column(nullable = false, length = 50)
    private String description;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private boolean status;

}
