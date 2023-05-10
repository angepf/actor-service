package com.cloud.microservices.actorservice.datajpa.repository;

import com.cloud.microservices.actorservice.datajpa.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, String> {
}
