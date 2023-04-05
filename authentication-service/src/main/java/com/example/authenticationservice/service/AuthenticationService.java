package com.example.authenticationservice.service;


import com.example.authenticationservice.CurrentUser;
import com.example.authenticationservice.dto.*;
import com.example.authenticationservice.entity.User;
import com.example.authenticationservice.entity.UserDevice;
import com.example.authenticationservice.entity.UserRole;
import com.example.authenticationservice.entity.token.RefreshToken;
import com.example.authenticationservice.exception.TokenRefreshException;
import com.example.authenticationservice.exception.UserLogoutException;
import com.example.authenticationservice.repository.RefreshTokenRepository;
import com.example.authenticationservice.repository.UserRepository;
import com.example.authenticationservice.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;


@Service
@Slf4j
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    private final AuthenticationManager authenticationManager;

    private final RefreshTokenServiceImpl refreshTokenService;

    private final UserDeviceServiceImpl userDeviceService;

    private final RefreshTokenRepository refreshTokenRepository;


    @Autowired
    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils,
                                 AuthenticationManager authenticationManager, RefreshTokenServiceImpl refreshTokenService,
                                 UserDeviceServiceImpl userDeviceService, RefreshTokenRepository refreshTokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.refreshTokenService = refreshTokenService;
        this.userDeviceService = userDeviceService;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public AuthenticationResponse registrationUser(RegistrationRequest registerRequest) {

        User user = new User();


        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setUserRole(UserRole.USER);
        user.setCreatedAt(Timestamp.from(Instant.now()));
        user.setIsAccountExpired(Boolean.TRUE);
        user.setActive(Boolean.TRUE);
        user.setIsAccountLocked(Boolean.TRUE);
        user.setEnabled(Boolean.TRUE);
        user.setIsTwilioVerified(Boolean.FALSE);

        userRepository.save(user);

        var jwtToken = jwtUtils.generateToken(user);
        var refreshToken = generateToken(user);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse(
                jwtToken,
                refreshToken
        );


        return authenticationResponse;
    }


    public Authentication authentication(AuthenticationRequest authenticationRequest) {

        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                authenticationRequest.getPassword()));

    }


    public Optional<String> refreshJwtToken(TokenRefreshRequest tokenRefreshRequest) {
        String requestRefreshToken = tokenRefreshRequest.getRefreshToken();

        return Optional.of(refreshTokenService.findByToken(requestRefreshToken)
                        .map(refreshToken -> {
                            refreshTokenService.verifyExpiration(refreshToken);
                            userDeviceService.verifyRefreshAvailability(refreshToken);
                            refreshTokenService.increaseCount(refreshToken);
                            return refreshToken;
                        })
                        .map(RefreshToken::getUserDevice)
                        .map(UserDevice::getUser)
                        .map(User::new)
                        .map(this::generateToken))
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Missing refresh token in database.Please login again"));
    }


    public Optional<RefreshToken> createAndPersistRefreshTokenForDevice(Authentication authentication, AuthenticationRequest loginRequest) {
        User currentUser = (User) authentication.getPrincipal();
        String deviceId = loginRequest.getDeviceInfo().getDeviceId();
        userDeviceService.findDeviceByUserId(currentUser.getId(), deviceId)
                .map(UserDevice::getRefreshToken)
                .map(RefreshToken::getId)
                .ifPresent(refreshTokenService::deleteById);

        UserDevice userDevice = userDeviceService.createUserDevice(loginRequest.getDeviceInfo());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken();
        userDevice.setUser(currentUser);
        userDevice.setRefreshToken(refreshToken);
        refreshToken.setUserDevice(userDevice);
        refreshToken = refreshTokenRepository.save(refreshToken);
        return Optional.ofNullable(refreshToken);
    }


    public String generateToken(User user) {
        return jwtUtils.generateToken(user);
    }


    public String changePassword(PasswordRequest passwordRequest, long id) {

        User user = userRepository.getById(id);

        user.setPassword(passwordRequest.getPassword());

        userRepository.save(user);

        return "Change Password";
    }


    public void logoutUser(@CurrentUser User currentUser, LogOutRequest logOutRequest) {
        String deviceId = logOutRequest.getDeviceInfo().getDeviceId();
        UserDevice userDevice = userDeviceService.findDeviceByUserId(currentUser.getId(), deviceId)
                .filter(device -> device.getDeviceId().equals(deviceId))
                .orElseThrow(() -> new UserLogoutException(logOutRequest.
                        getDeviceInfo().getDeviceId(), "Invalid device Id supplied. No matching device found for the given user "));

        log.info("Removing refresh token associated with device [" + userDevice + "]");
        refreshTokenService.deleteById(userDevice.getRefreshToken().getId());
    }
}
