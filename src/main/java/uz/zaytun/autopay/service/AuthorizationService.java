package uz.zaytun.autopay.service;

import uz.zaytun.autopay.service.dto.response.authorization.AuthorizationResponseDTO;
import uz.zaytun.autopay.service.dto.AutopayBaseResponse;

public interface AuthorizationService {
    AutopayBaseResponse<AuthorizationResponseDTO> login();
}
