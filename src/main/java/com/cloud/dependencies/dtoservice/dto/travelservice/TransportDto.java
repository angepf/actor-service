package com.cloud.dependencies.dtoservice.dto.travelservice;

import com.cloud.dependencies.dtoservice.dto.actorservice.DriverDto;
import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;
import com.cloud.dependencies.dtoservice.util.Constants;
import com.cloud.dependencies.dtoservice.dto.actorservice.OwnerDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = false)
@SuperBuilder
public class TransportDto {

    private String licencePlate;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private OwnerDto ownerId;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 10, max = 30, message = Constants.SIZE_MESSAGE)
    private String companyName;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 3, max = 10, message = Constants.SIZE_MESSAGE)
    private String registerNumber;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private DriverDto driverId;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private TransportTypeDto transportType;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 2, max = 10, message = Constants.SIZE_MESSAGE)
    private String color;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 4, max = 4, message = Constants.SIZE_MESSAGE)
    private String year;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private UserDto userId;

    private boolean status;
}
