package com.cloud.dependencies.dtoservice.mockData;

import com.cloud.dependencies.dtoservice.dto.travelservice.TransportTypeDto;

public class TransportTypeDtoMock {

    public static TransportTypeDto getTransportTypeDtoMock() {
        return TransportTypeDto.builder()
                .id( 1 )
                .description( "BUSETA" )
                .passengers( 12D )
                .build();
    }
}
