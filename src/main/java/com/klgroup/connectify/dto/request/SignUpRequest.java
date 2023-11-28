package com.klgroup.connectify.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpRequest {
    @Schema(example = "john12")
    private String username;
    @Schema(example = "12345678")
    private String password;
    @Schema(example = "John")
    private String firstName;
    @Schema(example = "Doe")
    private String lastName;
}