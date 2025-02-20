package com.example.autopayplugin.service.mockRestServer;


import com.example.autopayplugin.service.AuthorizationService;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.authorization.AuthorizationResponseDTO;
import com.example.autopayplugin.utils.DynamicDtoGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest(properties = {"autopay.simulate=true"})
public class AuthorizationMockServerTest {
    @Autowired
    private AuthorizationService service;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
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
    public void testLoginSuccess() throws Exception {
        AuthorizationResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(AuthorizationResponseDTO.class);
        responseDTO.setToken("token");
        AutopayBaseResponse<AuthorizationResponseDTO> baseResponse = AutopayBaseResponse.<AuthorizationResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/login"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<AuthorizationResponseDTO> response = service.login();

        assertNotNull(response);
        assertNotNull(response.getResult());
        assertEquals("token", response.getResult().getToken());
    }
}
