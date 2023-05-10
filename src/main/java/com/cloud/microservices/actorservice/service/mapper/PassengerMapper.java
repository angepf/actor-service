package com.cloud.microservices.actorservice.service.mapper;

import com.cloud.dependencies.dtoservice.dto.actorservice.PassengerDto;
import com.cloud.microservices.actorservice.datajpa.entity.Passenger;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

    PassengerDto toPassengerDto(Passenger passenger);

    Passenger toPassenger(PassengerDto passengerDto);

}