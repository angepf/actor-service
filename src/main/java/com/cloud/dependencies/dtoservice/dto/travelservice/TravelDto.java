package com.cloud.dependencies.dtoservice.dto.travelservice;

import com.cloud.dependencies.dtoservice.util.Constants;
import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = false)
@SuperBuilder
public class TravelDto {

    private Long id;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Timestamp date;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 5, max = 5, message = Constants.SIZE_MESSAGE)
    private String time;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private RouteDto routeId;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private TransportDto transportId;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private UserDto userId;

    private Boolean status;
}
