package com.cloud.dependencies.dtoservice.dto.actorservice;

import com.cloud.dependencies.dtoservice.util.Constants;
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
public class UserTypeDto {

    private Integer id;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 5, max = 20, message = Constants.SIZE_MESSAGE)
    private String description;

}
