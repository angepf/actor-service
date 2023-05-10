package com.cloud.dependencies.dtoservice.dto.actorservice;

import com.cloud.dependencies.dtoservice.util.Constants;
import jakarta.validation.constraints.Email;
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
public class PersonDto {

    @Size(min = 10, max = 13, message = Constants.SIZE_MESSAGE)
    private String id;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 5, max = 50, message = Constants.SIZE_MESSAGE)
    private String name;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 5, max = 50, message = Constants.SIZE_MESSAGE)
    private String lastName;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 10, max = 150, message = Constants.SIZE_MESSAGE)
    private String address;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Size(min = 10, max = 10, message = Constants.SIZE_MESSAGE)
    private String phone;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Email(message = Constants.EMAIL_MESSAGE)
    private String mail;

    @Size(max = 200, message = Constants.SIZE_MESSAGE)
    private String observation;

}
