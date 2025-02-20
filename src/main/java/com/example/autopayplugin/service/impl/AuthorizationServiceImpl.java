package com.example.autopayplugin.service.impl;

import com.example.autopayplugin.config.AutopayProperties;
import com.example.autopayplugin.service.AuthorizationService;
import com.example.autopayplugin.service.dto.AutopayBaseRequest;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.authorization.AuthorizationRequestDTO;
import com.example.autopayplugin.service.dto.authorization.AuthorizationResponseDTO;
import com.example.autopayplugin.utils.DTOFactory;
import com.example.autopayplugin.utils.ExceptionValidator;
import com.example.autopayplugin.utils.ResponseUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicReference;

import static com.example.autopayplugin.constants.Constants.LOGIN_API;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
    private final RestTemplate restTemplate;
    private final AutopayProperties autopayProperties;
    public static AtomicReference<AuthorizationResponseDTO> token = new AtomicReference<>(AuthorizationResponseDTO.builder().token("default").build());


    @Override
    @PostConstruct
    public AutopayBaseResponse<AuthorizationResponseDTO> login() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        AutopayBaseRequest<AuthorizationRequestDTO> request = DTOFactory.createAuthorizationDTO(autopayProperties.getUsername(), autopayProperties.getPassword());

        HttpEntity<AutopayBaseRequest<AuthorizationRequestDTO>> entity = new HttpEntity<>(request, headers);

        try {
            log.info("Sending login request: {}", request);
            ResponseEntity<AutopayBaseResponse<AuthorizationResponseDTO>> response = restTemplate.exchange(autopayProperties.getBaseUrl() + LOGIN_API,
                    HttpMethod.POST, entity, new ParameterizedTypeReference<>() {
                    });

            var validatedResponse = ResponseUtils.validateResponse(response);

            if (validatedResponse != null)
                return validatedResponse.getResult();

            if (response.getStatusCode().is2xxSuccessful()) {
                token.set(
                        AuthorizationResponseDTO.builder()
                                .token(response.getBody().getResult().getToken())
                                .build()
                );
            }

            log.info("Login response: {}", response.getBody());
            return response.getBody();
        } catch (Exception e) {
            log.error("Login failed: {}", e.getMessage());
            return ExceptionValidator.validateException(e);
        }
    }
}
