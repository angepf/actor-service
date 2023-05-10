package com.cloud.microservices.actorservice.controller;

import com.cloud.dependencies.dtoservice.exception.ResourceNotFoundException;
import com.cloud.microservices.actorservice.service.impl.UserServiceImpl;
import com.cloud.dependencies.dtoservice.mockData.UserDtoMock;
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

@WebMvcTest(UserController.class)
@TestPropertySource(locations = "classpath:application.properties")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString( obj );
    }

    @DisplayName("GetUser - OK")
    @Test
    void whenCallUrlUserWithCorrectDataThenOKStatus() throws Exception {
        Mockito.when( userService.getUserById( Mockito.anyString() ) )
                .thenReturn( UserDtoMock.getUserDtoMock() );

        mockMvc.perform( get( "/api/user/1" ) )
                .andExpect( status().isOk() );
    }

    @DisplayName("GetUser - Exception")
    @Test
    void whenCallUrlUserWithIncorrectDataThenBadRequestStatus() throws Exception {
        Mockito.when( userService.getUserById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        mockMvc.perform( get( "/api/user/1" ) )
                .andExpect( status().isNotFound() );
    }

    @DisplayName("CreateUser - OK")
    @Test
    void whenCallUrlUserSaveWithCorrectDataThenOKStatus() throws Exception {
        Mockito.when( userService.getUserById( Mockito.anyString() ) )
                .thenReturn( UserDtoMock.getUserDtoMock() );

        String inputJson = mapToJson( UserDtoMock.getUserDtoMock() );

        mockMvc.perform( post( "/api/user" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( inputJson ) )
                .andExpect( status().isOk() );
    }

    @DisplayName("CreateUser - Exception")
    @Test
    void whenCallUrlUserSaveWithIncorrectDataThenBadRequestStatus() throws Exception {
        Mockito.when( userService.getUserById( Mockito.anyString() ) )
                .thenThrow( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        String inputJson = mapToJson( new ResourceNotFoundException( "NotFound", "id", "id" ) );

        mockMvc.perform( post( "/api/user" )
                        .accept( MediaType.APPLICATION_JSON )
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( inputJson ) )
                .andExpect( status().isBadRequest() );
    }
}
