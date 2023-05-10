package com.cloud.dependencies.dtoservice.mockData;

import com.cloud.dependencies.dtoservice.dto.actorservice.DriverDto;

public class DriverDtoMock {

    public static DriverDto getDriverDtoMock() {
        return DriverDto.builder()
                .id( "0000000005" )
                .name( "JUAN ANTONIO" )
                .lastName( "LOJA MALDONADO" )
                .address( "CIRCUNVALACION SUR" )
                .phone( "0983265478" )
                .mail( "JUANL@GMAIL.COM" )
                .userId( UserDtoMock.getUserDtoMock() )
                .build();
    }
}
