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
@ToString(includeFieldNames = false, callSuper = true)
@SuperBuilder
public class UserDto extends PersonDto {

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 5, max = 15, message = Constants.SIZE_MESSAGE)
    private String username;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 5, max = 15, message = Constants.SIZE_MESSAGE)
    private String password;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private UserTypeDto userType;

    private boolean status;

}
