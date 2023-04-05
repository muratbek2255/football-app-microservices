package com.example.authenticationservice.controller;


import com.example.authenticationservice.CurrentUser;
import com.example.authenticationservice.dto.*;
import com.example.authenticationservice.entity.User;
import com.example.authenticationservice.entity.token.RefreshToken;
import com.example.authenticationservice.exception.TokenRefreshException;
import com.example.authenticationservice.exception.UserLoginException;
import com.example.authenticationservice.service.AuthenticationService;
import com.example.authenticationservice.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, JwtUtils jwtUtils) {
        this.authenticationService = authenticationService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest
                                                                   registerRequest) {
        return ResponseEntity.status(201).body(authenticationService.registrationUser(registerRequest));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest
                                                                       authenticationRequest) {

        Authentication authentication = (Authentication) authenticationService.authentication(authenticationRequest);

        User user = (User) authentication.getPrincipal();

        return ResponseEntity.status(201).body(authenticationService.createAndPersistRefreshTokenForDevice(authentication,
                        authenticationRequest)
                .map(RefreshToken::getToken)
                .map(refreshToken -> {
                    String jwtToken = jwtUtils.generateToken(user);
                    String refreshToken2 = jwtUtils.generateToken(user);
                    return new AuthenticationResponse(jwtToken, refreshToken);
                }).orElseThrow(() -> new UserLoginException("Couldn't create refresh token for: " +
                        "[" + authenticationRequest + "]")));
    }

    @PostMapping("/refresh")
    public JwtAuthenticationResponse refreshJwtToken(@Param(value = "The TokenRefreshRequest payload") @RequestBody
                                              TokenRefreshRequest tokenRefreshRequest) {

        return authenticationService.refreshJwtToken(tokenRefreshRequest)
                .map(updatedToken -> {
                    String refreshToken = tokenRefreshRequest.getRefreshToken();
                    log.info("Created new Jwt Auth token: " + updatedToken);
                    return ResponseEntity.ok(new JwtAuthenticationResponse(updatedToken, refreshToken,
                            jwtUtils.getExpiryDuration()));
                })
                .orElseThrow(() -> new TokenRefreshException(tokenRefreshRequest.getRefreshToken(),
                        "Unexpected error during token refresh. Please logout and login again.")).getBody();
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@CurrentUser User user, @Param(value = "The LogOutRequest payload")
    @RequestBody LogOutRequest logOutRequest) {
        authenticationService.logoutUser(user, logOutRequest);
        Object credentials = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return ResponseEntity.ok(new ApiResponse(true, "Log out successful"));
    }
}