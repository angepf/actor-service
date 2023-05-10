package com.cloud.microservices.actorservice.datajpa.repository;

import com.cloud.microservices.actorservice.datajpa.entity.PassengerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerTypeRepository extends JpaRepository<PassengerType, Integer> {
}
