package com.cloud.microservices.actorservice.service.impl;

import com.cloud.dependencies.dtoservice.dto.actorservice.OwnerDto;
import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.datajpa.repository.OwnerRepository;
import com.cloud.microservices.actorservice.datajpa.repository.UserRepository;
import com.cloud.microservices.actorservice.service.OwnerService;
import com.cloud.microservices.actorservice.service.mapper.OwnerMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OwnerServiceImpl implements OwnerService {

    OwnerRepository ownerRepository;

    OwnerMapper ownerMapper;

    UserRepository userRepository;


    @Override
    public OwnerDto getOwnerById(String ownerId) {
        log.info( "Start service :: getOwnerById: [{}]", ownerId );

        return ownerMapper.toOwnerDto( ownerRepository.findById( ownerId )
                .orElseThrow( () -> new ResourceNotFoundException( "Owner", "ownerId", ownerId ) ) );
    }

    @Override
    public OwnerDto createOwner(OwnerDto ownerDto) {
        log.info( "Start service :: createOwner: [{}]", ownerDto );

        String userId = ownerDto.getUserId().getId();

        userRepository.findById( userId )
                .orElseThrow( () -> new ResourceNotFoundException( "User", "id", userId ) );

        return ownerMapper.toOwnerDto( ownerRepository.save( ownerMapper.toOwner( ownerDto ) ) );
    }
}
