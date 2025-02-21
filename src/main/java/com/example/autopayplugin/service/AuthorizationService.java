package com.example.autopayplugin.service;

import com.example.autopayplugin.service.dto.response.authorization.AuthorizationResponseDTO;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;

public interface AuthorizationService {
    AutopayBaseResponse<AuthorizationResponseDTO> login();
}
