package com.cloud.dependencies.dtoservice.mockData;

import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;
import com.cloud.dependencies.dtoservice.dto.actorservice.UserTypeDto;

public class UserDtoMock {

    public static UserDto getUserDtoMock() {
        return UserDto.builder()
                .userType( getUserTypeDtoMock() )
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

    public static UserTypeDto getUserTypeDtoMock() {
        return UserTypeDto.builder()
                .id( 1 )
                .description( "TAX" )
                .build();
    }
}
