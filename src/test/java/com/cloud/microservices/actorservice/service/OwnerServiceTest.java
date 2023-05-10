package com.cloud.microservices.actorservice.service;

import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.datajpa.repository.OwnerRepository;
import com.cloud.microservices.actorservice.datajpa.repository.UserRepository;
import com.cloud.microservices.actorservice.mockData.OwnerMock;
import com.cloud.microservices.actorservice.mockData.UserMock;
import com.cloud.microservices.actorservice.service.impl.OwnerServiceImpl;
import com.cloud.microservices.actorservice.service.mapper.OwnerMapper;
import com.cloud.dependencies.dtoservice.mockData.OwnerDtoMock;
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
public class OwnerServiceTest {


    @Mock
    OwnerRepository ownerRepository;

    @Mock
    OwnerMapper ownerMapper;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    OwnerServiceImpl ownerService;

    @DisplayName("GetOwner - OK")
    @Test
    void whenGetOwnerByIdThenOkResponse() {
        Mockito.when( ownerRepository.findById( Mockito.anyString() ) )
                .thenReturn( Optional.of( OwnerMock.getOwnerMock() ) );

        Mockito.when( ownerMapper.toOwnerDto( Mockito.any() ) )
                .thenReturn( OwnerDtoMock.getOwnerDtoMock() );

        Assertions.assertEquals( OwnerDtoMock.getOwnerDtoMock().getId(), ownerService.getOwnerById( "0000000001" ).getId() );

    }

    @DisplayName("GetOwner - Exception")
    @Test
    void whenGetOwnerByIdThenExceptionResponse() {
        Mockito.when( ownerRepository.findById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "Owner", "id", "3" ) );

        Mockito.when( ownerMapper.toOwnerDto( Mockito.any() ) )
                .thenReturn( OwnerDtoMock.getOwnerDtoMock() );

        Exception exception = Assertions.assertThrows(
                ResourceNotFoundException.class, () -> ownerService.getOwnerById( "3" ) );

        Assertions.assertEquals( ResourceNotFoundException.class, exception.getClass() );
    }

    @DisplayName("CreateOwner - OK")
    @Test
    void whenCreateOwnerByIdThenOkResponse() {
        Mockito.when( ownerRepository.save( Mockito.any() ) )
                .thenReturn( OwnerMock.getOwnerMock() );

        Mockito.when( ownerMapper.toOwnerDto( Mockito.any() ) )
                .thenReturn( OwnerDtoMock.getOwnerDtoMock() );

        Mockito.when( ownerMapper.toOwner( Mockito.any() ) )
                .thenReturn( OwnerMock.getOwnerMock() );

        Mockito.when( userRepository.findById( Mockito.any() ) )
                .thenReturn( Optional.of( UserMock.getUserMock() ) );

        Assertions.assertEquals( OwnerDtoMock.getOwnerDtoMock().getId(), ownerService.createOwner( OwnerDtoMock.getOwnerDtoMock() ).getId() );
    }

    @DisplayName("CreateOwner - Exception")
    @Test
    void whenCreateOwnerByIdThenException1Response() {
        Mockito.when( ownerRepository.save( Mockito.any() ) )
                .thenReturn( OwnerMock.getOwnerMock() );

        Mockito.when( ownerMapper.toOwnerDto( Mockito.any() ) )
                .thenReturn( OwnerDtoMock.getOwnerDtoMock() );

        Mockito.when( ownerMapper.toOwner( Mockito.any() ) )
                .thenReturn( OwnerMock.getOwnerMock() );

        Mockito.when( userRepository.findById( Mockito.any() ) )
                .thenThrow( new ResourceNotFoundException( "User", "id", "0000000001" ) );

        Exception exception = Assertions.assertThrows(
                ResourceNotFoundException.class, () -> ownerService.createOwner( OwnerDtoMock.getOwnerDtoMock() ) );

        Assertions.assertEquals( ResourceNotFoundException.class, exception.getClass() );
    }
}
