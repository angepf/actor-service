package com.cloud.microservices.actorservice.controller;

import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;
import com.cloud.microservices.actorservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for User Service",
        description = "CRUD REST APIs - Create User, Get User"
)
@Log4j2
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(
            summary = "Get user REST API",
            description = "Get user by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId) {
        log.info( "Start controller :: getUserById: [{}]", userId );
        return new ResponseEntity<>( userService.getUserById( userId ), HttpStatus.OK );
    }

    @Operation(
            summary = "Post user REST API",
            description = "Post user by body to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATE"
    )
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
        log.info( "Start controller :: createUser: [{}]", userDto );
        return new ResponseEntity<>( userService.createUser( userDto ), HttpStatus.OK );
    }

}
