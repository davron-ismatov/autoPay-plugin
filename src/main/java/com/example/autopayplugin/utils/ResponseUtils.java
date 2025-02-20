package com.example.autopayplugin.utils;

import com.example.autopayplugin.domain.enumeration.Errors;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Slf4j
public class ResponseUtils {

    public static <T> AutopayBaseResponse<T> validateResponse(ResponseEntity<T> responseEntity) {
        if (responseEntity == null) {
            log.debug("Response is null");
            return DTOFactory.createAutopayBaseResponseForUnknownError(Errors.RESPONSE_IS_NULL.getMessage().messageUz(), Errors.RESPONSE_IS_NULL);
        }

        if (responseEntity.getBody() == null) {
            log.debug("Response body is null");
            return DTOFactory.createAutopayBaseResponseForUnknownError(Errors.RESPONSE_BODY_IS_NULL.getMessage().messageUz(), Errors.RESPONSE_IS_NULL);
        }

        if (responseEntity.getBody() instanceof AutopayBaseResponse<?> autopayBaseResponse && autopayBaseResponse.getResult() == null) {
            log.debug("Response body result is null");
            return DTOFactory.createAutopayBaseResponseForUnknownError(Errors.RESULT_IS_NULL.getMessage().messageUz(), Errors.RESULT_IS_NULL);
        }

        if (responseEntity.getStatusCode().is5xxServerError()) {
            log.debug("Internal server error occurred: {}", responseEntity.getBody());
            throw new HttpServerErrorException(responseEntity.getStatusCode());
        }

        if (responseEntity.getStatusCode().is4xxClientError()) {
            log.debug("Client server error occurred: {}", responseEntity.getBody());
            throw new HttpClientErrorException(responseEntity.getStatusCode());
        }

        return null;
    }
}