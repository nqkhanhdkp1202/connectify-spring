package com.klgroup.connectify.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpResponse {
    @Schema(example = "john12")
    private String username;
    @Schema(example = "John")
    private String firstName;
    @Schema(example = "Doe")
    private String lastName;
}