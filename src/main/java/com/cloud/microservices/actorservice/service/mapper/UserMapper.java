package com.cloud.microservices.actorservice.service.mapper;

import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;
import com.cloud.microservices.actorservice.datajpa.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

}