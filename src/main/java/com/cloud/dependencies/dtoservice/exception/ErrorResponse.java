package com.cloud.dependencies.dtoservice.exception;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private LocalDateTime timestamp;
    private List<String> errorMessage;
    private String path;
    private String errorCode;
}
