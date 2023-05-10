package com.cloud.microservices.actorservice.service;

import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.datajpa.repository.PassengerRepository;
import com.cloud.microservices.actorservice.datajpa.repository.PassengerTypeRepository;
import com.cloud.microservices.actorservice.datajpa.repository.UserRepository;
import com.cloud.microservices.actorservice.mockData.PassengerMock;
import com.cloud.microservices.actorservice.mockData.UserMock;
import com.cloud.microservices.actorservice.service.impl.PassengerServiceImpl;
import com.cloud.microservices.actorservice.service.mapper.PassengerMapper;
import com.cloud.dependencies.dtoservice.mockData.PassengerDtoMock;
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
public class PassengerServiceTest {


    @Mock
    PassengerRepository passengerRepository;

    @Mock
    PassengerMapper passengerMapper;

    @Mock
    UserRepository userRepository;

    @Mock
    PassengerTypeRepository passengerTypeRepository;

    @InjectMocks
    PassengerServiceImpl passengerService;

    @DisplayName("GetPassenger - OK")
    @Test
    void whenGetPassengerByIdThenOkResponse() {
        Mockito.when( passengerRepository.findById( Mockito.anyString() ) )
                .thenReturn( Optional.of( PassengerMock.getPassengerMock() ) );

        Mockito.when( passengerMapper.toPassengerDto( Mockito.any() ) )
                .thenReturn( PassengerDtoMock.getPassengerDtoMock() );

        Assertions.assertEquals( PassengerDtoMock.getPassengerDtoMock().getId(), passengerService.getPassengerById( "0000000001" ).getId() );

    }

    @DisplayName("GetPassenger - Exception")
    @Test
    void whenGetPassengerByIdThenExceptionResponse() {
        Mockito.when( passengerRepository.findById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "Passenger", "id", "3" ) );

        Mockito.when( passengerMapper.toPassengerDto( Mockito.any() ) )
                .thenReturn( PassengerDtoMock.getPassengerDtoMock() );

        Exception exception = Assertions.assertThrows(
                ResourceNotFoundException.class, () -> passengerService.getPassengerById( "3" ) );

        Assertions.assertEquals( ResourceNotFoundException.class, exception.getClass() );
    }

    @DisplayName("CreatePassenger - OK")
    @Test
    void whenCreatePassengerByIdThenOkResponse() {
        Mockito.when( passengerRepository.save( Mockito.any() ) )
                .thenReturn( PassengerMock.getPassengerMock() );

        Mockito.when( passengerMapper.toPassengerDto( Mockito.any() ) )
                .thenReturn( PassengerDtoMock.getPassengerDtoMock() );

        Mockito.when( passengerMapper.toPassenger( Mockito.any() ) )
                .thenReturn( PassengerMock.getPassengerMock() );

        Mockito.when( userRepository.findById( Mockito.any() ) )
                .thenReturn( Optional.of( UserMock.getUserMock() ) );

        Mockito.when( passengerTypeRepository.findById( Mockito.any() ) )
                .thenReturn( Optional.of( PassengerMock.getPassengerTypeMock() ) );

        Assertions.assertEquals( PassengerDtoMock.getPassengerDtoMock().getId(), passengerService.createPassenger( PassengerDtoMock.getPassengerDtoMock() ).getId() );
    }

    @DisplayName("CreatePassenger - Exception")
    @Test
    void whenCreatePassengerByIdThenException1Response() {
        Mockito.when( passengerRepository.save( Mockito.any() ) )
                .thenReturn( PassengerMock.getPassengerMock() );

        Mockito.when( passengerMapper.toPassengerDto( Mockito.any() ) )
                .thenReturn( PassengerDtoMock.getPassengerDtoMock() );

        Mockito.when( passengerMapper.toPassenger( Mockito.any() ) )
                .thenReturn( PassengerMock.getPassengerMock() );

        Mockito.when( passengerTypeRepository.findById( Mockito.any() ) )
                .thenReturn( Optional.of( PassengerMock.getPassengerTypeMock() ) );

        Mockito.when( userRepository.findById( Mockito.any() ) )
                .thenThrow( new ResourceNotFoundException( "User", "id", "0000000001" ) );

        Exception exception = Assertions.assertThrows(
                ResourceNotFoundException.class, () -> passengerService.createPassenger( PassengerDtoMock.getPassengerDtoMock() ) );

        Assertions.assertEquals( ResourceNotFoundException.class, exception.getClass() );
    }
}
