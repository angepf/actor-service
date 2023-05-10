package com.cloud.microservices.actorservice.service.impl;

import com.cloud.dependencies.dtoservice.dto.actorservice.PassengerDto;
import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.datajpa.repository.PassengerRepository;
import com.cloud.microservices.actorservice.datajpa.repository.PassengerTypeRepository;
import com.cloud.microservices.actorservice.datajpa.repository.UserRepository;
import com.cloud.microservices.actorservice.service.mapper.PassengerMapper;
import com.cloud.microservices.actorservice.service.PassengerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PassengerServiceImpl implements PassengerService {

    PassengerRepository passengerRepository;

    PassengerMapper passengerMapper;

    PassengerTypeRepository passengerTypeRepository;

    UserRepository userRepository;

    @Override
    public PassengerDto getPassengerById(String passengerId) {
        log.info( "Start service :: getPassengerById: [{}]", passengerId );

        return passengerMapper.toPassengerDto( passengerRepository.findById( passengerId )
                .orElseThrow( () -> new ResourceNotFoundException( "Passenger", "id", passengerId ) ) );
    }

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {
        log.info( "Start service :: createPassenger: [{}]", passengerDto );

        Integer passengerTypeId = passengerDto.getPassengerType().getId();
        String userId = passengerDto.getUserId().getId();

        passengerTypeRepository.findById( passengerTypeId )
                .orElseThrow( () -> new ResourceNotFoundException( "PassengerType", "id", passengerTypeId.toString() ) );

        userRepository.findById( userId )
                .orElseThrow( () -> new ResourceNotFoundException( "User", "id", userId ) );

        return passengerMapper.toPassengerDto( passengerRepository.save( passengerMapper.toPassenger( passengerDto ) ) );
    }
}
