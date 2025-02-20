package com.example.autopayplugin.service.mockRestServer;

import com.example.autopayplugin.constants.Constants;
import com.example.autopayplugin.service.ContractService;
import com.example.autopayplugin.service.dto.AutopayBaseRequest;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.contract.*;
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
public class ContractMockServerTest {
    @Autowired
    private ContractService service;
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
    public void create_with_client_on_success() throws JsonProcessingException {
        ContractCreateWithClientDTO dto = DynamicDtoGenerator.generateDefaultObject(ContractCreateWithClientDTO.class);
        var baseRequest = AutopayBaseRequest.<ContractCreateWithClientDTO>builder().method(Constants.CONTRACT_CREATE_WITH_CLIENT).params(dto).build();
        ContractCreateWithClientResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(ContractCreateWithClientResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<ContractCreateWithClientResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<ContractCreateWithClientResponseDTO> response = service.createWithClient(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    public void update_client_on_success() throws JsonProcessingException {
        ContractUpdateRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(ContractUpdateRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<ContractUpdateRequestDTO>builder().method(Constants.CONTRACT_UPDATE).params(dto).build();
        ContractUpdateResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(ContractUpdateResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<ContractUpdateResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<ContractUpdateResponseDTO> response = service.update(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    public void bulk_update_client_on_success() throws JsonProcessingException {
        ContractBulkUpdateRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(ContractBulkUpdateRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<ContractBulkUpdateRequestDTO>builder().method(Constants.CONTRACT_BULK_UPDATE).params(dto).build();
        ContractBulkUpdateResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(ContractBulkUpdateResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<ContractBulkUpdateResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<ContractBulkUpdateResponseDTO> response = service.bulkUpdate(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    public void get_client_on_success() throws JsonProcessingException {
        ContractGetRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(ContractGetRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<ContractGetRequestDTO>builder().method(Constants.CONTRACT_GET).params(dto).build();
        ContractGetResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(ContractGetResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<ContractGetResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<ContractGetResponseDTO> response = service.get(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    public void delete_client_on_success() throws JsonProcessingException {
        ContractDeleteRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(ContractDeleteRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<ContractDeleteRequestDTO>builder().method(Constants.CONTRACT_DELETE).params(dto).build();
        ContractDeleteResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(ContractDeleteResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<ContractDeleteResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<ContractDeleteResponseDTO> response = service.delete(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }

    @Test
    public void auto_toggle_client_on_success() throws JsonProcessingException {
        ContractAutoToggleRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(ContractAutoToggleRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<ContractAutoToggleRequestDTO>builder().method(Constants.CONTRACT_AUTO_TOGGLE).params(dto).build();
        ContractAutoToggleResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(ContractAutoToggleResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<ContractAutoToggleResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<ContractAutoToggleResponseDTO> response = service.autoToggle(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }


    @Test
    public void find_client_on_success() throws JsonProcessingException {
        ContractFindRequestDTO dto = DynamicDtoGenerator.generateDefaultObject(ContractFindRequestDTO.class);
        var baseRequest = AutopayBaseRequest.<ContractFindRequestDTO>builder().method(Constants.CONTRACT_FIND).params(dto).build();
        ContractFindResponseDTO responseDTO = DynamicDtoGenerator.generateDefaultObject(ContractFindResponseDTO.class);
        var baseResponse = AutopayBaseResponse.<ContractFindResponseDTO>builder().result(responseDTO).build();

        mockServer.expect(requestTo("http://localhost:8080/api/v1/partners"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(objectMapper.writeValueAsString(baseRequest)))
                .andRespond(withSuccess(objectMapper.writeValueAsString(baseResponse), MediaType.APPLICATION_JSON));

        AutopayBaseResponse<ContractFindResponseDTO> response = service.find(dto);

        assertNotNull(response);
        assertNotNull(response.getResult());
    }
}
