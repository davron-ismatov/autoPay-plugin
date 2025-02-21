package uz.zaytun.autopay.service;

import uz.zaytun.autopay.service.dto.AutopayBaseResponse;
import uz.zaytun.autopay.service.dto.request.contract.*;
import uz.zaytun.autopay.service.dto.response.contract.*;

public interface ContractService {
    AutopayBaseResponse<ContractCreateWithClientResponseDTO> createWithClient(ContractCreateWithClientRequestRequestDTO dto);

    AutopayBaseResponse<ContractUpdateResponseDTO> update(ContractUpdateRequestDTO dto);

    AutopayBaseResponse<ContractBulkUpdateResponseDTO> bulkUpdate(ContractBulkUpdateRequestDTO dto);

    AutopayBaseResponse<ContractGetResponseDTO> get(ContractGetRequestDTO dto);

    AutopayBaseResponse<ContractDeleteResponseDTO> delete(ContractDeleteRequestDTO dto);

    AutopayBaseResponse<ContractAutoToggleResponseDTO> autoToggle(ContractAutoToggleRequestDTO dto);

    AutopayBaseResponse<ContractFindResponseDTO> find(ContractFindRequestDTO dto);
}
