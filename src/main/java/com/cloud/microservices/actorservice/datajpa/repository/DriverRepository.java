package com.cloud.microservices.actorservice.datajpa.repository;

import com.cloud.microservices.actorservice.datajpa.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, String> {
}
