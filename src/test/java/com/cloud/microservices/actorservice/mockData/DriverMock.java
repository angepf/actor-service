package com.cloud.microservices.actorservice.mockData;

import com.cloud.dependencies.dtoservice.dto.actorservice.DriverDto;
import com.cloud.microservices.actorservice.datajpa.entity.Driver;

public class DriverMock {

    public static Driver getDriverMock() {
        return Driver.builder()
                .id( "0000000005" )
                .name( "JUAN ANTONIO" )
                .lastName( "LOJA MALDONADO" )
                .address( "CIRCUNVALACION SUR" )
                .phone( "0983265478" )
                .mail( "JUANL@GMAIL.COM" )
                .userId( UserMock.getUserMock() )
                .build();
    }

}
