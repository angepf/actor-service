package com.cloud.microservices.actorservice.controller;

import com.cloud.dependencies.dtoservice.dto.actorservice.PassengerDto;
import com.cloud.microservices.actorservice.service.PassengerService;
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
        name = "CRUD REST APIs for Passenger Service",
        description = "CRUD REST APIs - Create Passenger, Get Passenger"
)
@Log4j2
@RestController
@RequestMapping("api/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @Operation(
            summary = "Get passenger REST API",
            description = "Get passenger by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/{passengerId}")
    public ResponseEntity<?> getPassengerById(@PathVariable String passengerId) {
        log.info( "Start controller :: getPassengerById: [{}]", passengerId );
        return new ResponseEntity<>( passengerService.getPassengerById( passengerId ), HttpStatus.OK );
    }

    @Operation(
            summary = "Post passenger REST API",
            description = "Post passenger by body to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATE"
    )
    @PostMapping
    public ResponseEntity<?> createPassenger(@Valid @RequestBody PassengerDto passengerDto) {
        log.info( "Start controller :: createPassenger: [{}]", passengerDto );
        return new ResponseEntity<>( passengerService.createPassenger( passengerDto ), HttpStatus.OK );
    }

}
