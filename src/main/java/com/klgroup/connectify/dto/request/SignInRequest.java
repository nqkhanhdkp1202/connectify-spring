package com.klgroup.connectify.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInRequest {
    @Schema(example = "john12")
    private String username;
    @Schema(example = "12345678")
    private String password;
}