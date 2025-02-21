package uz.zaytun.autopay.service.impl;

import uz.zaytun.autopay.config.AutopayProperties;
import uz.zaytun.autopay.service.AuthorizationService;
import uz.zaytun.autopay.service.dto.AutopayBaseRequest;
import uz.zaytun.autopay.service.dto.AutopayBaseResponse;
import uz.zaytun.autopay.service.dto.request.authorization.AuthorizationRequestDTO;
import uz.zaytun.autopay.service.dto.response.authorization.AuthorizationResponseDTO;
import uz.zaytun.autopay.utils.DTOFactory;
import uz.zaytun.autopay.utils.ExceptionValidator;
import uz.zaytun.autopay.utils.AutopayResponseUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicReference;

import static uz.zaytun.autopay.constants.Constants.LOGIN_API;


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

            var validatedResponse = AutopayResponseUtils.validateResponse(response);

            if (!validatedResponse.getStatus())
                return validatedResponse.getResult();

            token.set(
                    AuthorizationResponseDTO.builder()
                            .token(response.getBody().getResult().getToken())
                            .build()
            );


            log.info("Login response: {}", response.getBody());
            return response.getBody();
        } catch (Exception e) {
            log.error("Login failed: {}", e.getMessage());
            return ExceptionValidator.validateException(e);
        }
    }
}
