package com.cloud.dependencies.dtoservice.mockData;

import com.cloud.dependencies.dtoservice.dto.actorservice.OwnerDto;

public class OwnerDtoMock {

    public static OwnerDto getOwnerDtoMock() {
        return OwnerDto.builder()
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
