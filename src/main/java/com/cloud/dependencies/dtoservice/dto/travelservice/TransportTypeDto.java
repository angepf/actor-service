package com.cloud.dependencies.dtoservice.dto.travelservice;

import com.cloud.dependencies.dtoservice.util.Constants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class TransportTypeDto {

    private Integer id;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 5, max = 30, message = Constants.SIZE_MESSAGE)
    private String description;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Min( value = 2, message = Constants.MIN_MESSAGE)
    @Max( value = 20, message = Constants.MAX_MESSAGE)
    private Double passengers;

}
