package com.cloud.dependencies.dtoservice.mockData;

import com.cloud.dependencies.dtoservice.dto.ticketservice.TicketDto;

import java.sql.Timestamp;
import java.time.Instant;

public class TicketDtoMock {

    public static TicketDto getTicketDtoMock() {
        return TicketDto.builder()
                .id( 1L )
                .date( Timestamp.from( Instant.now() ) )
                .passengerId( PassengerDtoMock.getPassengerDtoMock() )
                .travelId( TravelDtoMock.getTravelDtoMock() )
                .userId( UserDtoMock.getUserDtoMock() )
                .build();
    }
}
