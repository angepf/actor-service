package com.cloud.dependencies.dtoservice.dto.ticketservice;

import com.cloud.dependencies.dtoservice.dto.actorservice.PassengerDto;
import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;
import com.cloud.dependencies.dtoservice.dto.travelservice.TravelDto;
import com.cloud.dependencies.dtoservice.util.Constants;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Setter
@Getter
@Builder
@ToString(includeFieldNames = false)
public class TicketDto {

    private Long id;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Timestamp date;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private TravelDto travelId;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private PassengerDto passengerId;

    private Boolean isUsed;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private UserDto userId;

}