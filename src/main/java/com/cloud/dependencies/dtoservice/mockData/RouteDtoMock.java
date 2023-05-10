package com.cloud.dependencies.dtoservice.mockData;

import com.cloud.dependencies.dtoservice.dto.travelservice.RouteDto;

public class RouteDtoMock {

    public static RouteDto getRouteDtoMock(){
        return RouteDto.builder()
                .id( 1 )
                .routeFrom( "CUENCA CENTRO" )
                .routeTo( "LOJA SUR" )
                .userId( UserDtoMock.getUserDtoMock() )
                .build();
    }
}
