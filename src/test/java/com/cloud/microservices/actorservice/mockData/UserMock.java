package com.cloud.microservices.actorservice.mockData;

import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;
import com.cloud.dependencies.dtoservice.dto.actorservice.UserTypeDto;
import com.cloud.microservices.actorservice.datajpa.entity.User;
import com.cloud.microservices.actorservice.datajpa.entity.UserType;

public class UserMock {

    public static User getUserMock() {
        return User.builder()
                .userType(getUserTypeMock() )
                .id( "0000000001" )
                .name( "JUAN ANTONIO" )
                .lastName( "VERA CORDOVA" )
                .address( "AUTOPISTA NORTE" )
                .phone( "0987345764" )
                .mail( "JUAN@GMAIL.COM" )
                .username( "JUANV" )
                .password( "AAAODE#)$" )
                .build();
    }

    public static UserType getUserTypeMock() {
        return UserType.builder()
                .id( 1 )
                .description( "TAX" )
                .build();
    }

}
