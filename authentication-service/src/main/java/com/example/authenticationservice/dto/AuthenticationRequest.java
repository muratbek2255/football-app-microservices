package com.example.authenticationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationRequest {

    private String username;

    private String password;

    private DeviceInfo deviceInfo;
}
