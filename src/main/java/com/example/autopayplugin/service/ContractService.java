package com.example.autopayplugin.service;

import com.example.autopayplugin.service.dto.AutopayBaseResponse;
import com.example.autopayplugin.service.dto.contract.*;

public interface ContractService {
    AutopayBaseResponse<ContractCreateWithClientResponseDTO> createWithClient(ContractCreateWithClientDTO dto);

    AutopayBaseResponse<ContractUpdateResponseDTO> update(ContractUpdateRequestDTO dto);

    AutopayBaseResponse<ContractBulkUpdateResponseDTO> bulkUpdate(ContractBulkUpdateRequestDTO dto);

    AutopayBaseResponse<ContractGetResponseDTO> get(ContractGetRequestDTO dto);

    AutopayBaseResponse<ContractDeleteResponseDTO> delete(ContractDeleteRequestDTO dto);

    AutopayBaseResponse<ContractAutoToggleResponseDTO> autoToggle(ContractAutoToggleRequestDTO dto);

    AutopayBaseResponse<ContractFindResponseDTO> find(ContractFindRequestDTO dto);
}
