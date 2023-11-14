package com.klgroup.connectify;

import com.klgroup.connectify.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ConnectifyApplication implements CommandLineRunner {
    private final AuthenticationService authenticationService;

    public static void main(String[] args) {
        SpringApplication.run(ConnectifyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        authenticationService.createAdminIfNotExists();
    }
}
