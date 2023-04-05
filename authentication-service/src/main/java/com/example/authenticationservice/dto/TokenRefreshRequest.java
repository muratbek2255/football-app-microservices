package com.example.authenticationservice.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TokenRefreshRequest {

    private String refreshToken;

}
