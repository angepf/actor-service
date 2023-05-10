package com.cloud.microservices.actorservice.service;

import com.cloud.dependencies.dtoservice.dto.actorservice.DriverDto;

public interface DriverService {

    DriverDto getDriverById(String driverId);

    DriverDto createDriver(DriverDto driverDto);

}
