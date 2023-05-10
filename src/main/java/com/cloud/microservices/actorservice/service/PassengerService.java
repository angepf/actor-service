package com.cloud.microservices.actorservice.service;

import com.cloud.dependencies.dtoservice.dto.actorservice.PassengerDto;

public interface PassengerService {

    PassengerDto getPassengerById(String passengerId);

    PassengerDto createPassenger(PassengerDto passengerDto);

}
