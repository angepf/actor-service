package com.cloud.microservices.actorservice.controller;

import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.service.impl.OwnerServiceImpl;
import com.cloud.dependencies.dtoservice.mockData.OwnerDtoMock;
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

@WebMvcTest(OwnerController.class)
@TestPropertySource(locations = "classpath:application.properties")
public class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerServiceImpl ownerService;

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString( obj );
    }

    @DisplayName("GetOwner - OK")
    @Test
    void whenCallUrlOwnerWithCorrectDataThenOKStatus() throws Exception {
        Mockito.when( ownerService.getOwnerById( Mockito.anyString() ) )
                .thenReturn( OwnerDtoMock.getOwnerDtoMock() );

        mockMvc.perform( get( "/api/owner/1" ) )
                .andExpect( status().isOk() );
    }

    @DisplayName("GetOwner - Exception")
    @Test
    void whenCallUrlOwnerWithIncorrectDataThenBadRequestStatus() throws Exception {
        Mockito.when( ownerService.getOwnerById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        mockMvc.perform( get( "/api/owner/1" ) )
                .andExpect( status().isNotFound() );
    }

    @DisplayName("CreateOwner - OK")
    @Test
    void whenCallUrlOwnerSaveWithCorrectDataThenOKStatus() throws Exception {
        Mockito.when( ownerService.getOwnerById( Mockito.anyString() ) )
                .thenReturn( OwnerDtoMock.getOwnerDtoMock() );

        String inputJson = mapToJson( OwnerDtoMock.getOwnerDtoMock() );

        mockMvc.perform( post( "/api/owner" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( inputJson ) )
                .andExpect( status().isOk() );
    }

    @DisplayName("CreateOwner - Exception")
    @Test
    void whenCallUrlOwnerSaveWithIncorrectDataThenBadRequestStatus() throws Exception {
        Mockito.when( ownerService.getOwnerById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        String inputJson = mapToJson( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        mockMvc.perform( post( "/api/owner" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( inputJson ) )
                .andExpect( status().isBadRequest() );
    }
}
