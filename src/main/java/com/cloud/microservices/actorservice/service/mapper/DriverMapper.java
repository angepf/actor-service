package com.cloud.microservices.actorservice.service.mapper;

import com.cloud.dependencies.dtoservice.dto.actorservice.DriverDto;
import com.cloud.microservices.actorservice.datajpa.entity.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    DriverDto toDriverDto(Driver driver);

    Driver toDriver(DriverDto driverDto);

}