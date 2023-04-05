package com.example.authenticationservice.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class PasswordRequest {

    private String password;
}
