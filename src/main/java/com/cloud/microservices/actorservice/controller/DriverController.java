package com.cloud.microservices.actorservice.controller;

import com.cloud.dependencies.dtoservice.dto.actorservice.DriverDto;
import com.cloud.microservices.actorservice.service.DriverService;
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
        name = "CRUD REST APIs for Driver Service",
        description = "CRUD REST APIs - Create Driver, Get Driver"
)
@Log4j2
@RestController
@RequestMapping("api/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @Operation(
            summary = "Get driver REST API",
            description = "Get driver by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/{driverId}")
    public ResponseEntity<?> getDriverById(@PathVariable String driverId) {
        log.info( "Start controller :: getDriverById: [{}]", driverId );
        return new ResponseEntity<>( driverService.getDriverById( driverId ), HttpStatus.OK );
    }

    @Operation(
            summary = "Post driver REST API",
            description = "Post driver by body to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATE"
    )
    @PostMapping
    public ResponseEntity<?> createDriver(@Valid @RequestBody DriverDto driverDto) {
        log.info( "Start controller :: createDriver: [{}]", driverDto );
        return new ResponseEntity<>( driverService.createDriver( driverDto ), HttpStatus.OK );
    }

}
