package com.cloud.microservices.actorservice.service;

import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.datajpa.repository.UserRepository;
import com.cloud.microservices.actorservice.datajpa.repository.UserTypeRepository;
import com.cloud.microservices.actorservice.mockData.UserMock;
import com.cloud.microservices.actorservice.service.impl.UserServiceImpl;
import com.cloud.microservices.actorservice.service.mapper.UserMapper;
import com.cloud.dependencies.dtoservice.mockData.UserDtoMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {


    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @Mock
    UserTypeRepository userTypeRepository;

    @InjectMocks
    UserServiceImpl userService;

    @DisplayName("GetUser - OK")
    @Test
    void whenGetUserByIdThenOkResponse() {
        Mockito.when( userRepository.findById( Mockito.anyString() ) )
                .thenReturn( Optional.of( UserMock.getUserMock() ) );

        Mockito.when( userMapper.toUserDto( Mockito.any() ) )
                .thenReturn( UserDtoMock.getUserDtoMock() );

        Assertions.assertEquals( UserDtoMock.getUserDtoMock().getId(), userService.getUserById( "0000000001" ).getId() );

    }

    @DisplayName("GetUser - Exception")
    @Test
    void whenGetUserByIdThenExceptionResponse() {
        Mockito.when( userRepository.findById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "User", "id", "3" ) );

        Mockito.when( userMapper.toUserDto( Mockito.any() ) )
                .thenReturn( UserDtoMock.getUserDtoMock() );

        Exception exception = Assertions.assertThrows(
                ResourceNotFoundException.class, () -> userService.getUserById( "3" ) );

        Assertions.assertEquals( ResourceNotFoundException.class, exception.getClass() );
    }

    @DisplayName("CreateUser - OK")
    @Test
    void whenCreateUserByIdThenOkResponse() {
        Mockito.when( userRepository.save( Mockito.any() ) )
                .thenReturn( UserMock.getUserMock() );

        Mockito.when( userMapper.toUserDto( Mockito.any() ) )
                .thenReturn( UserDtoMock.getUserDtoMock() );

        Mockito.when( userMapper.toUser( Mockito.any() ) )
                .thenReturn( UserMock.getUserMock() );

        Mockito.when( userRepository.findById( Mockito.any() ) )
                .thenReturn( Optional.of( UserMock.getUserMock() ) );

        Mockito.when( userTypeRepository.findById( Mockito.any() ) )
                .thenReturn( Optional.of( UserMock.getUserTypeMock() ) );

        Assertions.assertEquals( UserDtoMock.getUserDtoMock().getId(), userService.createUser( UserDtoMock.getUserDtoMock() ).getId() );
    }

    @DisplayName("CreateUser - Exception")
    @Test
    void whenCreateUserByIdThenException1Response() {
        Mockito.when( userRepository.save( Mockito.any() ) )
                .thenReturn( UserMock.getUserMock() );

        Mockito.when( userMapper.toUserDto( Mockito.any() ) )
                .thenReturn( UserDtoMock.getUserDtoMock() );

        Mockito.when( userMapper.toUser( Mockito.any() ) )
                .thenReturn( UserMock.getUserMock() );

        Mockito.when( userTypeRepository.findById( Mockito.any() ) )
                .thenThrow( new ResourceNotFoundException( "UserType", "id", "1" ) );

        Exception exception = Assertions.assertThrows(
                ResourceNotFoundException.class, () -> userService.createUser( UserDtoMock.getUserDtoMock() ) );

        Assertions.assertEquals( ResourceNotFoundException.class, exception.getClass() );
    }
}
