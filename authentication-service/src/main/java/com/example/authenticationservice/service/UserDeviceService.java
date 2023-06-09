package com.example.authenticationservice.service;

import com.example.authenticationservice.dto.DeviceInfo;
import com.example.authenticationservice.entity.UserDevice;
import com.example.authenticationservice.entity.token.RefreshToken;

import java.util.Optional;

public interface UserDeviceService {

    public Optional<UserDevice> findDeviceByUserId(Long userId, String deviceId);

    public Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken);

    public UserDevice createUserDevice(DeviceInfo deviceInfo);

    public void verifyRefreshAvailability(RefreshToken refreshToken);
}
