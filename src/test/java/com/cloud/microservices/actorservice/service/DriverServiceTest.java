package com.cloud.microservices.actorservice.service;

import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.datajpa.repository.DriverRepository;
import com.cloud.microservices.actorservice.datajpa.repository.UserRepository;
import com.cloud.microservices.actorservice.mockData.DriverMock;
import com.cloud.microservices.actorservice.mockData.UserMock;
import com.cloud.microservices.actorservice.service.impl.DriverServiceImpl;
import com.cloud.microservices.actorservice.service.mapper.DriverMapper;
import com.cloud.dependencies.dtoservice.mockData.DriverDtoMock;
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
public class DriverServiceTest {


    @Mock
    DriverRepository driverRepository;

    @Mock
    DriverMapper driverMapper;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    DriverServiceImpl driverService;

    @DisplayName("GetDriver - OK")
    @Test
    void whenGetDriverByIdThenOkResponse() {
        Mockito.when( driverRepository.findById( Mockito.anyString() ) )
                .thenReturn( Optional.of( DriverMock.getDriverMock() ) );

        Mockito.when( driverMapper.toDriverDto( Mockito.any() ) )
                .thenReturn( DriverDtoMock.getDriverDtoMock() );

        Assertions.assertEquals( DriverDtoMock.getDriverDtoMock().getId(), driverService.getDriverById( "0000000001" ).getId() );

    }

    @DisplayName("GetDriver - Exception")
    @Test
    void whenGetDriverByIdThenExceptionResponse() {
        Mockito.when( driverRepository.findById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "Driver", "id", "3" ) );

        Mockito.when( driverMapper.toDriverDto( Mockito.any() ) )
                .thenReturn( DriverDtoMock.getDriverDtoMock() );

        Exception exception = Assertions.assertThrows(
                ResourceNotFoundException.class, () -> driverService.getDriverById( "3" ) );

        Assertions.assertEquals( ResourceNotFoundException.class, exception.getClass() );
    }

    @DisplayName("CreateDriver - OK")
    @Test
    void whenCreateDriverByIdThenOkResponse() {
        Mockito.when( driverRepository.save( Mockito.any() ) )
                .thenReturn( DriverMock.getDriverMock() );

        Mockito.when( driverMapper.toDriverDto( Mockito.any() ) )
                .thenReturn( DriverDtoMock.getDriverDtoMock() );

        Mockito.when( driverMapper.toDriver( Mockito.any() ) )
                .thenReturn( DriverMock.getDriverMock() );

        Mockito.when( userRepository.findById( Mockito.any() ) )
                .thenReturn( Optional.of( UserMock.getUserMock() ) );

        Assertions.assertEquals( DriverDtoMock.getDriverDtoMock().getId(), driverService.createDriver( DriverDtoMock.getDriverDtoMock() ).getId() );
    }

    @DisplayName("CreateDriver - Exception")
    @Test
    void whenCreateDriverByIdThenException1Response() {
        Mockito.when( driverRepository.save( Mockito.any() ) )
                .thenReturn( DriverMock.getDriverMock() );

        Mockito.when( driverMapper.toDriverDto( Mockito.any() ) )
                .thenReturn( DriverDtoMock.getDriverDtoMock() );

        Mockito.when( driverMapper.toDriver( Mockito.any() ) )
                .thenReturn( DriverMock.getDriverMock() );

        Mockito.when( userRepository.findById( Mockito.any() ) )
                .thenThrow( new ResourceNotFoundException( "User", "id", "0000000001" ) );

        Exception exception = Assertions.assertThrows(
                ResourceNotFoundException.class, () -> driverService.createDriver( DriverDtoMock.getDriverDtoMock() ) );

        Assertions.assertEquals( ResourceNotFoundException.class, exception.getClass() );
    }
}
