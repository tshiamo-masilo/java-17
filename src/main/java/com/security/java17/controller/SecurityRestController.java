package com.security.java17.controller;


import com.security.java17.dto.LoginUserNamePasswordRequest;
import com.security.java17.model.JWToken;
import com.security.java17.model.LoginRequest;
import com.security.java17.model.UserData;
import com.security.java17.model.UserId;
import com.security.java17.services.JWTUtils;
import com.security.java17.services.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/services/security/")
public class SecurityRestController {

    private final UserAccessService userAccessService;
    private final HttpServletRequest request;

    @Autowired
    public SecurityRestController(UserAccessService userAccessService, HttpServletRequest request) {
        this.userAccessService = userAccessService;
        this.request = request;
    }

    @PostMapping("/login")
    public ResponseEntity<UserData> login(@RequestBody LoginUserNamePasswordRequest loginRequest) {
        Optional<UserData> userData = userAccessService.login(new LoginRequest(UserId.from(loginRequest.getUserName()), loginRequest.getPassword()));
        if (userData.isPresent()) {
            return ResponseEntity.ok().body(userData.get());
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout() {
        String authorization = request.getHeader("Authorization");
        JWToken jwToken = JWToken.from(JWTUtils.extractJwtToken(authorization));
        if (userAccessService.logout(jwToken)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}