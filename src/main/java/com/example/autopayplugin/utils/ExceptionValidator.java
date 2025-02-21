package com.example.autopayplugin.utils;

import com.example.autopayplugin.domain.enumeration.AutopayErrors;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.SocketTimeoutException;
import java.net.http.HttpConnectTimeoutException;

@Component
@RequiredArgsConstructor
public class ExceptionValidator {


    public static <T> AutopayBaseResponse<T> validateException(Exception e) {
        if (e instanceof HttpServerErrorException) {
            return DTOFactory.createAutopayBaseResponseForUnknownError(e.getMessage(), AutopayErrors.SERVER_ERROR);
        } else if (e instanceof HttpClientErrorException) {
            return DTOFactory.createAutopayBaseResponseForUnknownError(e.getMessage(), AutopayErrors.CLIENT_ERROR);
        } else if (e instanceof HttpConnectTimeoutException) {
            return DTOFactory.createAutopayBaseResponseForUnknownError(e.getMessage(), AutopayErrors.CONNECTION_TIMEOUT);
        } else if (e instanceof SocketTimeoutException) {
            return DTOFactory.createAutopayBaseResponseForUnknownError(e.getMessage(), AutopayErrors.READ_TIMEOUT);
        } else
            return DTOFactory.createAutopayBaseResponseForUnknownError(e.getMessage(), AutopayErrors.UNKNOWN_ERROR);
    }
}
