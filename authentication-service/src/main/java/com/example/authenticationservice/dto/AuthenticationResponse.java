package com.example.authenticationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {

    private String token;

    private String refreshToken;

}