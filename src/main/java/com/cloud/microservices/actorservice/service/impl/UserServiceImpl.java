package com.cloud.microservices.actorservice.service.impl;

import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;
import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.datajpa.repository.UserRepository;
import com.cloud.microservices.actorservice.datajpa.repository.UserTypeRepository;
import com.cloud.microservices.actorservice.service.UserService;
import com.cloud.microservices.actorservice.service.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    UserTypeRepository userTypeRepository;

    @Override
    public UserDto getUserById(String userId) {
        log.info( "Start service :: getUserById: [{}]", userId );

        return userMapper.toUserDto( userRepository.findById( userId )
                .orElseThrow( () -> new ResourceNotFoundException( "User", "userId", userId ) ) );
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info( "Start service :: createUser: [{}]", userDto );

        Integer userTypeId = userDto.getUserType().getId();

        userTypeRepository.findById( userTypeId )
                .orElseThrow( () -> new ResourceNotFoundException( "PassengerType", "id", userTypeId.toString() ) );

        return userMapper.toUserDto( userRepository.save( userMapper.toUser( userDto ) ) );
    }
}
