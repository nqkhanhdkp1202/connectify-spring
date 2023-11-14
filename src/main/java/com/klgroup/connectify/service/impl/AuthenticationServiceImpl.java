package com.klgroup.connectify.service.impl;

import com.klgroup.connectify.dto.request.SignInRequest;
import com.klgroup.connectify.dto.request.SignUpRequest;
import com.klgroup.connectify.dto.response.JwtAuthenticationResponse;
import com.klgroup.connectify.exception.CustomException;
import com.klgroup.connectify.model.Admin;
import com.klgroup.connectify.model.EndUser;
import com.klgroup.connectify.repository.AdminRepository;
import com.klgroup.connectify.repository.BaseUserRepository;
import com.klgroup.connectify.service.AuthenticationService;
import com.klgroup.connectify.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final BaseUserRepository userRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final ModelMapper modelMapper;
    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        if(userRepository.existsByUsername(request.getUsername())){
            throw new CustomException("Username already exists", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var user = modelMapper.map(request, EndUser.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public void createAdminIfNotExists() {
        if(!adminRepository.existsAdminByIdNotNull()){
            var admin = new Admin();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123456"));

            adminRepository.save(admin);
        }
    }
}