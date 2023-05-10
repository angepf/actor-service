package com.cloud.microservices.actorservice.datajpa.repository;

import com.cloud.microservices.actorservice.datajpa.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
}
