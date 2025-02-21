package uz.zaytun.autopay.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.zaytun.autopay.constants.Constants;
import uz.zaytun.autopay.service.ContractService;
import uz.zaytun.autopay.service.RequestSenderService;
import uz.zaytun.autopay.service.dto.AutopayBaseRequest;
import uz.zaytun.autopay.service.dto.AutopayBaseResponse;
import uz.zaytun.autopay.service.dto.request.contract.*;
import uz.zaytun.autopay.service.dto.response.contract.*;
import uz.zaytun.autopay.utils.DTOFactory;

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
