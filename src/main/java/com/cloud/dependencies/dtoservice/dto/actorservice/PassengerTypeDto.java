package com.cloud.dependencies.dtoservice.dto.actorservice;

import com.cloud.dependencies.dtoservice.util.Constants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@ToString(includeFieldNames = false)
@SuperBuilder
public class PassengerTypeDto {

    private Integer id;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(max = 20, message = Constants.SIZE_MESSAGE)
    private String description;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Max(value = 50, message = Constants.MAX_MESSAGE)
    @Min(value = 1, message = Constants.MIN_MESSAGE)
    private double cost;

    private boolean status;

}
