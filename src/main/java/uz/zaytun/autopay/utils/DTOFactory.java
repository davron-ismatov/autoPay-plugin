package uz.zaytun.autopay.utils;

import uz.zaytun.autopay.domain.enumeration.AutopayErrors;
import uz.zaytun.autopay.service.dto.request.authorization.AuthorizationRequestDTO;
import uz.zaytun.autopay.service.dto.AutopayBaseRequest;
import uz.zaytun.autopay.service.dto.AutopayBaseResponse;
import uz.zaytun.autopay.service.dto.ErrorResponseDTO;

import static uz.zaytun.autopay.constants.Constants.LOGIN;

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


    public static <T> AutopayBaseResponse<T> createAutopayBaseResponseForUnknownError(String errorMessage, AutopayErrors status) {
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

    public static <T> AutopayBaseResponse<T> createAutopayBaseResponseForUnknownError(Boolean isSuccessful, AutopayErrors status) {
        return AutopayBaseResponse.<T>builder()
                .status(isSuccessful)
                .error(
                        ErrorResponseDTO.builder()
                                .message(status.getMessage().uz())
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
