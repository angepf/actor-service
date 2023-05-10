package com.cloud.microservices.actorservice.service.impl;

import com.cloud.dependencies.dtoservice.dto.actorservice.DriverDto;
import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.service.DriverService;
import com.cloud.microservices.actorservice.service.mapper.DriverMapper;
import com.cloud.microservices.actorservice.datajpa.repository.DriverRepository;
import com.cloud.microservices.actorservice.datajpa.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverServiceImpl implements DriverService {

    DriverRepository driverRepository;

    DriverMapper driverMapper;

    UserRepository userRepository;


    @Override
    public DriverDto getDriverById(String driverId) {
        log.info( "Start service :: getDriverById: [{}]", driverId );

        return driverMapper.toDriverDto( driverRepository.findById( driverId )
                .orElseThrow( () -> new ResourceNotFoundException( "Driver", "id", driverId ) ) );
    }

    @Override
    public DriverDto createDriver(DriverDto driverDto) {
        log.info( "Start service :: createDriver: [{}]", driverDto );

        String userId = driverDto.getUserId().getId();

        userRepository.findById( userId )
                .orElseThrow( () -> new ResourceNotFoundException( "User", "id", userId ) );

        return driverMapper.toDriverDto( driverRepository.save( driverMapper.toDriver( driverDto ) ) );
    }
}
