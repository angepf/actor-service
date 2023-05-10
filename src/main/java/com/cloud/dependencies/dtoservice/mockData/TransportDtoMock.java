package com.cloud.dependencies.dtoservice.mockData;

import com.cloud.dependencies.dtoservice.dto.travelservice.TransportTypeDto;
import com.cloud.dependencies.dtoservice.dto.travelservice.TransportDto;

public class TransportDtoMock {

    public static TransportDto getTransportDtoMock() {
        return TransportDto.builder()
                .licencePlate( "ADF9873" )
                .color( "GRISSS" )
                .transportType( TransportTypeDtoMock.getTransportTypeDtoMock() )
                .companyName( "TRANSPORTES AMERICA" )
                .year( "2009" )
                .ownerId( OwnerDtoMock.getOwnerDtoMock() )
                .driverId( DriverDtoMock.getDriverDtoMock() )
                .registerNumber( "093843" )
                .status( true )
                .userId( UserDtoMock.getUserDtoMock() )
                .build();
    }

    public static TransportTypeDto getTransportTypeDtoMock() {
        return TransportTypeDto.builder()
                .id( 1 )
                .description( "BUSETA" )
                .passengers( 12D )
                .build();
    }
}
