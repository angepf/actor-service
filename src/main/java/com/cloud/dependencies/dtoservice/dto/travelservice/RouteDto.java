package com.cloud.dependencies.dtoservice.dto.travelservice;

import com.cloud.dependencies.dtoservice.dto.actorservice.UserDto;
import com.cloud.dependencies.dtoservice.util.Constants;
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
public class RouteDto {

    private Integer id;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(max = 20, message = Constants.SIZE_MESSAGE)
    private String routeFrom;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(max = 20, message = Constants.SIZE_MESSAGE)
    private String routeTo;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private UserDto userId;
}
