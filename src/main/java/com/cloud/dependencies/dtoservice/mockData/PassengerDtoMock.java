package com.cloud.dependencies.dtoservice.mockData;

import com.cloud.dependencies.dtoservice.dto.actorservice.PassengerDto;
import com.cloud.dependencies.dtoservice.dto.actorservice.PassengerTypeDto;

public class PassengerDtoMock {

    public static PassengerDto getPassengerDtoMock() {
        return PassengerDto.builder()
                .id( "0000000005" )
                .name( "JUAN ANTONIO" )
                .lastName( "LOJA MALDONADO" )
                .address( "CIRCUNVALACION SUR" )
                .phone( "0983265478" )
                .mail( "JUANL@GMAIL.COM" )
                .userId( UserDtoMock.getUserDtoMock() )
                .passengerType( getPassengerTypeDtoMock() )
                .build();
    }

    public static PassengerTypeDto getPassengerTypeDtoMock() {
        return PassengerTypeDto.builder()
                .id( 1 )
                .cost( 12 )
                .status( true )
                .description( "STUDENT" )
                .build();
    }
}
