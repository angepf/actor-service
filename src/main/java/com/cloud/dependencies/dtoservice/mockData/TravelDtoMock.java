package com.cloud.dependencies.dtoservice.mockData;

import com.cloud.dependencies.dtoservice.dto.travelservice.TravelDto;

import java.sql.Timestamp;
import java.time.Instant;

public class TravelDtoMock {

    public static TravelDto getTravelDtoMock() {
        return TravelDto.builder()
                .id( 1L )
                .date( Timestamp.from( Instant.now() ) )
                .routeId( RouteDtoMock.getRouteDtoMock() )
                .time( "09:00" )
                .transportId( TransportDtoMock.getTransportDtoMock() )
                .status( true )
                .userId( UserDtoMock.getUserDtoMock() )
                .build();
    }
}
