package com.example.autopayplugin.utils;

import com.example.autopayplugin.domain.enumeration.Errors;
import com.example.autopayplugin.service.dto.authorization.AuthorizationRequestDTO;
import com.example.autopayplugin.service.dto.AutopayBaseRequest;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.ErrorResponseDTO;

import static com.example.autopayplugin.constants.Constants.LOGIN;

public class DTOFactory {
    public static AutopayBaseRequest<AuthorizationRequestDTO> createAuthorizationDTO(String username, String password) {
        return AutopayBaseRequest.<AuthorizationRequestDTO>builder()
                .method(LOGIN)
                .params(AuthorizationRequestDTO.builder()
                        .username(username)
                        .password(password)
                        .build())
                .build();
    }


    public static <T> AutopayBaseResponse<T> createAutopayBaseResponseForUnknownError(String errorMessage, Errors status) {
        return AutopayBaseResponse.<T>builder()
                .status(false)
                .error(
                        ErrorResponseDTO.builder()
                                .message(errorMessage)
                                .status(status)
                                .build()
                )
                .build();
    }

    public static <T> AutopayBaseRequest<T> createAutopayBaseRequestDTO(String methodName, T dto) {
        return AutopayBaseRequest.<T>builder()
                .method(methodName)
                .params(dto)
                .build();
    }
}
