package com.example.autopayplugin.utils;

import com.example.autopayplugin.domain.enumeration.AutopayErrors;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class AutopayResponseUtils {

    public static <T> AutopayBaseResponse<T> validateResponse(ResponseEntity<T> responseEntity) {
        if (responseEntity == null) {
            log.debug("Response is null");
            return DTOFactory.createAutopayBaseResponseForUnknownError(false, AutopayErrors.RESPONSE_IS_NULL);
        }

        if (responseEntity.getBody() == null) {
            log.debug("Response body is null");
            return DTOFactory.createAutopayBaseResponseForUnknownError(false, AutopayErrors.RESPONSE_IS_NULL);
        }

        if (responseEntity.getBody() instanceof AutopayBaseResponse<?> autopayBaseResponse && autopayBaseResponse.getResult() == null) {
            log.debug("Response body result is null");
            return DTOFactory.createAutopayBaseResponseForUnknownError(false, AutopayErrors.RESULT_IS_NULL);
        }

        return AutopayBaseResponse.<T>builder().status(true).build();
    }
}