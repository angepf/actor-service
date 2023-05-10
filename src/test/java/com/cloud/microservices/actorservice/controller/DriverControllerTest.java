package com.cloud.microservices.actorservice.controller;

import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.service.impl.DriverServiceImpl;
import com.cloud.dependencies.dtoservice.mockData.DriverDtoMock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DriverController.class)
@TestPropertySource(locations = "classpath:application.properties")
public class DriverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DriverServiceImpl driverService;

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString( obj );
    }

    @DisplayName("GetDriver - OK")
    @Test
    void whenCallUrlDriverWithCorrectDataThenOKStatus() throws Exception {
        Mockito.when( driverService.getDriverById( Mockito.anyString() ) )
                .thenReturn( DriverDtoMock.getDriverDtoMock() );

        mockMvc.perform( get( "/api/driver/1" ) )
                .andExpect( status().isOk() );
    }

    @DisplayName("GetDriver - Exception")
    @Test
    void whenCallUrlDriverWithIncorrectDataThenBadRequestStatus() throws Exception {
        Mockito.when( driverService.getDriverById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        mockMvc.perform( get( "/api/driver/1" ) )
                .andExpect( status().isNotFound() );
    }

    @DisplayName("CreateDriver - OK")
    @Test
    void whenCallUrlDriverSaveWithCorrectDataThenOKStatus() throws Exception {
        Mockito.when( driverService.getDriverById( Mockito.anyString() ) )
                .thenReturn( DriverDtoMock.getDriverDtoMock() );

        String inputJson = mapToJson( DriverDtoMock.getDriverDtoMock() );

        mockMvc.perform( post( "/api/driver" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( inputJson ) )
                .andExpect( status().isOk() );
    }

    @DisplayName("CreateDriver - Exception")
    @Test
    void whenCallUrlDriverSaveWithIncorrectDataThenBadRequestStatus() throws Exception {
        Mockito.when( driverService.getDriverById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        String inputJson = mapToJson( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        mockMvc.perform( post( "/api/driver" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( inputJson ) )
                .andExpect( status().isBadRequest() );
    }
}
