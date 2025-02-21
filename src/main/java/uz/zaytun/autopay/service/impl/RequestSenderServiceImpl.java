package uz.zaytun.autopay.service.impl;

import uz.zaytun.autopay.config.AutopayProperties;
import uz.zaytun.autopay.constants.Constants;
import uz.zaytun.autopay.domain.enumeration.AutopayErrors;
import uz.zaytun.autopay.service.AuthorizationService;
import uz.zaytun.autopay.service.RequestSenderService;
import uz.zaytun.autopay.service.dto.AutopayBaseRequest;
import uz.zaytun.autopay.service.dto.AutopayBaseResponse;
import uz.zaytun.autopay.utils.DTOFactory;
import uz.zaytun.autopay.utils.ExceptionValidator;
import uz.zaytun.autopay.utils.AutopayResponseUtils;
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
