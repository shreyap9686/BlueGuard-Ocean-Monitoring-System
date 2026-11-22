package com.blueguard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // USER REGISTRATION
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        try {
            User registeredUser = authService.register(user);

            return ResponseEntity.ok(
                    Map.of(
                            "message", "Registration successful!",
                            "name", registeredUser.getFullName(),
                            "email", registeredUser.getEmail()
                    )
            );

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(
                    Map.of("error", e.getMessage())
            );
        }
    }

    // USER LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {

        String email = credentials.get("email");
        String password = credentials.get("password");

        if (email == null || password == null ||
                email.isBlank() || password.isBlank()) {

            return ResponseEntity.badRequest().body(
                    Map.of("error", "Email and password are required!")
            );
        }

        boolean authenticated = authService.login(email, password);

        if (authenticated) {
            return ResponseEntity.ok(
                    Map.of("message", "Login successful!")
            );
        }

        return ResponseEntity.status(401).body(
                Map.of("error", "Invalid email or password!")
        );
    }
}
