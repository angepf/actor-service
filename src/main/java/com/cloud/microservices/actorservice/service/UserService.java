package com.cloud.microservices.actorservice.service;

import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;

public interface UserService {

    UserDto getUserById(String userId);

    UserDto createUser(UserDto userDto);

}
