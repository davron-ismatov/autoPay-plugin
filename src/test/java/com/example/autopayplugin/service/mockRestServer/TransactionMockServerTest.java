package com.example.autopayplugin.service.mockRestServer;

import com.example.autopayplugin.constants.Constants;
import com.example.autopayplugin.service.TransactionService;
import com.example.autopayplugin.service.dto.AutopayBaseRequest;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.request.transaction.*;
import com.example.autopayplugin.service.dto.response.transaction.*;
import com.example.autopayplugin.utils.DynamicDtoGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest(properties = {"autopay.simulate=true"})
public class TransactionMockServerTest {
    @Autowired
    private TransactionService service;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    @Qualifier("autopayObjectMapper")
    private ObjectMapper objectMapper;
    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setup() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @AfterEach
    public void verify() {
        mockServer.verify();
    }


    @Test
    void test_get_transaction_on_success() throws JsonProcessingException {
        TransactionGetRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(TransactionGetRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<TransactionGetRequestDTO>builder().method(Constants.TRANSACTION_GET).params(dto).build();
        TransactionGetResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(TransactionGetResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<TransactionGetResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<TransactionGetResponseDTO> response = service.get(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    void test_sync_transaction_on_success() throws JsonProcessingException {
        TransactionSynchRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(TransactionSynchRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<TransactionSynchRequestDTO>builder().method(Constants.TRANSACTION_SYNCHRONIZE).params(dto).build();
        TransactionSynchResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(TransactionSynchResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<TransactionSynchResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<TransactionSynchResponseDTO> response = service.sync(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    void test_transaction_find_by_ext_on_success() throws JsonProcessingException {
        TransactionFindAndCancelRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(TransactionFindAndCancelRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<TransactionFindAndCancelRequestDTO>builder().method(Constants.TRANSACTION_FIND).params(dto).build();
        TransactionDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(TransactionDTO.class);
        var baseResponse = AutopayBaseResponse.<TransactionDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<TransactionDTO> response = service.findByExt(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    void test_transaction_cancel_on_success() throws JsonProcessingException {
        TransactionFindAndCancelRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(TransactionFindAndCancelRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<TransactionFindAndCancelRequestDTO>builder().method(Constants.TRANSACTION_CANCEL).params(dto).build();
        TransactionCancelResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(TransactionCancelResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<TransactionCancelResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<TransactionCancelResponseDTO> response = service.cancel(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    void test_verification_set_transaction_on_success() throws JsonProcessingException {
        TransactionVerificationSetRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(TransactionVerificationSetRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<TransactionVerificationSetRequestDTO>builder().method(Constants.TRANSACTION_VERIFICATION_SET).params(dto).build();
        TransactionVerificationSetResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(TransactionVerificationSetResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<TransactionVerificationSetResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<TransactionVerificationSetResponseDTO> response = service.verificationSet(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    void test_verification_check_transaction_on_success() throws JsonProcessingException {
        TransactionVerificationCheckRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(TransactionVerificationCheckRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<TransactionVerificationCheckRequestDTO>builder().method(Constants.TRANSACTION_VERIFICATION_CHECK).params(dto).build();
        TransactionVerificationCheckResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(TransactionVerificationCheckResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<TransactionVerificationCheckResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<TransactionVerificationCheckResponseDTO> response = service.verificationCheck(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }
}
