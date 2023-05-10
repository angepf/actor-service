package com.cloud.microservices.actorservice.datajpa.repository;

import com.cloud.microservices.actorservice.datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
