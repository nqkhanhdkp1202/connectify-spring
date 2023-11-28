package com.klgroup.connectify.service;

import com.klgroup.connectify.dto.request.SignInRequest;
import com.klgroup.connectify.dto.request.SignUpRequest;
import com.klgroup.connectify.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);

    void createAdminIfNotExists();
}