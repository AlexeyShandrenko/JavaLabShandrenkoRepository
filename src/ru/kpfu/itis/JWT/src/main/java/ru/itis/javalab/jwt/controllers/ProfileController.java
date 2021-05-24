package ru.itis.javalab.jwt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> getProfile() {
        return ResponseEntity.ok("profile page!");
    }

}
