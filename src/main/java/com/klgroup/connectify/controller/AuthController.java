package com.klgroup.connectify.controller;

import com.klgroup.connectify.dto.request.SignInRequest;
import com.klgroup.connectify.dto.request.SignUpRequest;
import com.klgroup.connectify.dto.response.JwtAuthenticationResponse;
import com.klgroup.connectify.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(description = "Auth API", name = "Auth Services")
public class AuthController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signUp")
    @Operation(summary = "${AuthController.signUp}")
    @ApiResponses(value = {//
            @ApiResponse(responseCode = "400", description = "Something went wrong"), //
            @ApiResponse(responseCode = "403", description = "Access denied"), //
            @ApiResponse(responseCode = "422", description = "Username already exists")})
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @PostMapping("/signIn")
    @Operation(summary = "${AuthController.signIn}")
    @ApiResponses(value = {//
            @ApiResponse(responseCode = "400", description = "Something went wrong"), //
            @ApiResponse(responseCode = "403", description = "Access denied"), //
            @ApiResponse(responseCode = "422", description = "Username already exists")})
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}
