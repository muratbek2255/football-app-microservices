package com.example.authenticationservice.service;

import com.example.authenticationservice.entity.token.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

    public Optional<RefreshToken> findByToken(String token);

    public void verifyExpiration(RefreshToken token);

    public void deleteById(long id);

    public void increaseCount(RefreshToken refreshToken);
}
