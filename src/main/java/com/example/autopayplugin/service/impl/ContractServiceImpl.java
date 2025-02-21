package com.example.autopayplugin.service.impl;

import com.example.autopayplugin.constants.Constants;
import com.example.autopayplugin.service.ContractService;
import com.example.autopayplugin.service.RequestSenderService;
import com.example.autopayplugin.service.dto.AutopayBaseRequest;
import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.request.contract.*;
import com.example.autopayplugin.service.dto.response.contract.*;
import com.example.autopayplugin.utils.DTOFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final RequestSenderService requestSenderService;

    @Override
    public AutopayBaseResponse<ContractCreateWithClientResponseDTO> createWithClient(ContractCreateWithClientRequestRequestDTO dto) {
        log.info("createWithClient: {}", dto);

        AutopayBaseRequest<ContractCreateWithClientRequestRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(Constants.CONTRACT_CREATE_WITH_CLIENT, dto);

        return requestSenderService.sendRequest(request, ContractCreateWithClientResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<ContractUpdateResponseDTO> update(ContractUpdateRequestDTO dto) {
        log.info("update: {}", dto);

        AutopayBaseRequest<ContractUpdateRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(Constants.CONTRACT_UPDATE, dto);

        return requestSenderService.sendRequest(request, ContractUpdateResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<ContractBulkUpdateResponseDTO> bulkUpdate(ContractBulkUpdateRequestDTO dto) {
        log.info("bulkUpdate: {}", dto);

        AutopayBaseRequest<ContractBulkUpdateRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(Constants.CONTRACT_BULK_UPDATE, dto);

        return requestSenderService.sendRequest(request, ContractBulkUpdateResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<ContractGetResponseDTO> get(ContractGetRequestDTO dto) {
        log.info("get: {}", dto);

        AutopayBaseRequest<ContractGetRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(Constants.CONTRACT_GET, dto);

        return requestSenderService.sendRequest(request, ContractGetResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<ContractDeleteResponseDTO> delete(ContractDeleteRequestDTO dto) {
        log.info("delete: {}", dto);

        AutopayBaseRequest<ContractDeleteRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(Constants.CONTRACT_DELETE, dto);

        return requestSenderService.sendRequest(request, ContractDeleteResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<ContractAutoToggleResponseDTO> autoToggle(ContractAutoToggleRequestDTO dto) {
        log.info("autoToggle: {}", dto);

        AutopayBaseRequest<ContractAutoToggleRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(Constants.CONTRACT_AUTO_TOGGLE, dto);

        return requestSenderService.sendRequest(request, ContractAutoToggleResponseDTO.class);
    }

    @Override
    public AutopayBaseResponse<ContractFindResponseDTO> find(ContractFindRequestDTO dto) {
        log.info("find: {}", dto);

        AutopayBaseRequest<ContractFindRequestDTO> request = DTOFactory.createAutopayBaseRequestDTO(Constants.CONTRACT_FIND, dto);

        return requestSenderService.sendRequest(request, ContractFindResponseDTO.class);
    }


}
