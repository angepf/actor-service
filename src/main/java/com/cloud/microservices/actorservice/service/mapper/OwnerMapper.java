package com.cloud.microservices.actorservice.service.mapper;

import com.cloud.dependencies.dtoservice.dto.actorservice.OwnerDto;
import com.cloud.microservices.actorservice.datajpa.entity.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerDto toOwnerDto(Owner owner);

    Owner toOwner(OwnerDto ownerDto);

}