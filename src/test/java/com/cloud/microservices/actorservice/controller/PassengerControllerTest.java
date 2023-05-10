package com.cloud.microservices.actorservice.controller;

import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.service.impl.PassengerServiceImpl;
import com.cloud.dependencies.dtoservice.mockData.PassengerDtoMock;
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

@WebMvcTest(PassengerController.class)
@TestPropertySource(locations = "classpath:application.properties")
public class PassengerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PassengerServiceImpl passengerService;

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString( obj );
    }

    @DisplayName("GetPassenger - OK")
    @Test
    void whenCallUrlPassengerWithCorrectDataThenOKStatus() throws Exception {
        Mockito.when( passengerService.getPassengerById( Mockito.anyString() ) )
                .thenReturn( PassengerDtoMock.getPassengerDtoMock() );

        mockMvc.perform( get( "/api/passenger/1" ) )
                .andExpect( status().isOk() );
    }

    @DisplayName("GetPassenger - Exception")
    @Test
    void whenCallUrlPassengerWithIncorrectDataThenBadRequestStatus() throws Exception {
        Mockito.when( passengerService.getPassengerById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        mockMvc.perform( get( "/api/passenger/1" ) )
                .andExpect( status().isNotFound() );
    }

    @DisplayName("CreatePassenger - OK")
    @Test
    void whenCallUrlPassengerSaveWithCorrectDataThenOKStatus() throws Exception {
        Mockito.when( passengerService.getPassengerById( Mockito.anyString() ) )
                .thenReturn( PassengerDtoMock.getPassengerDtoMock() );

        String inputJson = mapToJson( PassengerDtoMock.getPassengerDtoMock() );

        mockMvc.perform( post( "/api/passenger" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( inputJson ) )
                .andExpect( status().isOk() );
    }

    @DisplayName("CreatePassenger - Exception")
    @Test
    void whenCallUrlPassengerSaveWithIncorrectDataThenBadRequestStatus() throws Exception {
        Mockito.when( passengerService.getPassengerById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        String inputJson = mapToJson( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        mockMvc.perform( post( "/api/passenger" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( inputJson ) )
                .andExpect( status().isBadRequest() );
    }
}
