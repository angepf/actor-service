package com.cloud.microservices.actorservice.mockData;

import com.cloud.dependencies.dtoservice.dto.actorservice.PassengerDto;
import com.cloud.dependencies.dtoservice.dto.actorservice.PassengerTypeDto;
import com.cloud.microservices.actorservice.datajpa.entity.Passenger;
import com.cloud.microservices.actorservice.datajpa.entity.PassengerType;

public class PassengerMock {

    public static Passenger getPassengerMock() {
        return Passenger.builder()
                .id( "0000000005" )
                .name( "JUAN ANTONIO" )
                .lastName( "LOJA MALDONADO" )
                .address( "CIRCUNVALACION SUR" )
                .phone( "0983265478" )
                .mail( "JUANL@GMAIL.COM" )
                .passengerType( getPassengerTypeMock() )
                .userId( UserMock.getUserMock() )
                .build();
    }

    public static PassengerType getPassengerTypeMock() {
        return PassengerType.builder()
                .id( 1 )
                .cost( 12 )
                .status( true )
                .description( "STUDENT" )
                .build();
    }

}
