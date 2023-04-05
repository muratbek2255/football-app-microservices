package com.example.authenticationservice.dto;


import com.example.authenticationservice.entity.DeviceType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class DeviceInfo {

    private String deviceId;

    private DeviceType deviceType;
}
