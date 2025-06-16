package com.DiorHomme.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.DiorHomme.hospital.service.AuthService;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");
        String token = authService.login(username, password);
        if (token == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> registrationRequest) {
        boolean success = authService.register(
            registrationRequest.get("username"),
            registrationRequest.get("password"),
            registrationRequest.get("email"),
            registrationRequest.get("name")
        );
        if (!success) {
            return ResponseEntity.badRequest().body("Registration failed");
        }
        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String token = authService.generateToken(username);
        if (token == null) {
            return ResponseEntity.badRequest().body("Token generation failed");
        }
        return ResponseEntity.ok(Map.of("token", token));
    }
}
