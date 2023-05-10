package com.cloud.microservices.actorservice.service;

import com.cloud.dependencies.dtoservice.dto.actorservice.OwnerDto;

public interface OwnerService {

    OwnerDto getOwnerById(String ownerId);

    OwnerDto createOwner(OwnerDto ownerDto);

}
