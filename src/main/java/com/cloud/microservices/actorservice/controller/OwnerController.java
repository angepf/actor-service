package com.cloud.microservices.actorservice.controller;

import com.cloud.dependencies.dtoservice.dto.actorservice.OwnerDto;
import com.cloud.microservices.actorservice.service.OwnerService;
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
        name = "CRUD REST APIs for Owner Service",
        description = "CRUD REST APIs - Create Owner, Get Owner"
)
@Log4j2
@RestController
@RequestMapping("api/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @Operation(
            summary = "Get owner REST API",
            description = "Get owner by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/{ownerId}")
    public ResponseEntity<?> getOwnerById(@PathVariable String ownerId) {
        log.info( "Start controller :: getOwnerById: [{}]", ownerId );
        return new ResponseEntity<>( ownerService.getOwnerById( ownerId ), HttpStatus.OK );
    }

    @Operation(
            summary = "Post owner REST API",
            description = "Post owner by body to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATE"
    )
    @PostMapping
    public ResponseEntity<?> createOwner(@Valid @RequestBody OwnerDto ownerDto) {
        log.info( "Start controller :: createOwner: [{}]", ownerDto );
        return new ResponseEntity<>( ownerService.createOwner( ownerDto ), HttpStatus.OK );
    }

}
