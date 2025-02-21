package com.example.autopayplugin.service.impl;

import com.example.autopayplugin.config.AutopayProperties;
import com.example.autopayplugin.constants.Constants;
import com.example.autopayplugin.domain.enumeration.AutopayErrors;
import com.example.autopayplugin.service.AuthorizationService;
import com.example.autopayplugin.service.RequestSenderService;
import com.example.autopayplugin.service.dto.AutopayBaseRequest;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.utils.DTOFactory;
import com.example.autopayplugin.utils.ExceptionValidator;
import com.example.autopayplugin.utils.AutopayResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RequestSenderServiceImpl implements RequestSenderService {
    private final RestTemplate restTemplate;
    private final AutopayProperties autopayProperties;
    private final AuthorizationService authorizationService;

    public RequestSenderServiceImpl(@Autowired @Qualifier("autopayRestTemplate") RestTemplate restTemplate, AutopayProperties autopayProperties, AuthorizationService authorizationService) {
        this.restTemplate = restTemplate;
        this.autopayProperties = autopayProperties;
        this.authorizationService = authorizationService;
    }

    @Override
    public <T, R> AutopayBaseResponse<R> sendRequest(AutopayBaseRequest<T> request, Class<R> responseClass) {
        try {
            log.info("sending request: {}", request);
            ResponseEntity<AutopayBaseResponse<R>> response = restTemplate.exchange(autopayProperties.getBaseUrl() + Constants.AUTOPAY_API, HttpMethod.POST,
                    new HttpEntity<>(request), new ParameterizedTypeReference<>() {
                    });

            var validatedResponse = AutopayResponseUtils.validateResponse(response);
            if (!validatedResponse.getStatus())
                return validatedResponse.getResult();

            log.info("response: {}", response.getBody());

            return response.getBody();
        } catch (HttpClientErrorException.Unauthorized exception) {
            authorizationService.login();
            return DTOFactory.createAutopayBaseResponseForUnknownError(exception.getMessage(), AutopayErrors.UNAUTHORIZED);
        } catch (Exception e) {
            log.warn("Exception occurred: {}", e.getMessage());
            return ExceptionValidator.validateException(e);
        }
    }
}
