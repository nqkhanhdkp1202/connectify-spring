package com.klgroup.connectify.controller;

import com.klgroup.connectify.model.Post;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Tag(description = "Test API", name = "Test Services")
public class TestController {
    @PreAuthorize("hasRole('ROLE_END_USER')")
    @GetMapping("/helloEndUser")
    public ResponseEntity<String> sayHelloToEndUser() {
        return ResponseEntity.ok("Hello");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/helloAdmin")
    public ResponseEntity<String> sayHelloToAdmin() {
        return ResponseEntity.ok("Hello");
    }

}