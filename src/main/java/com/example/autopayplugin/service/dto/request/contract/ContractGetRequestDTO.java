package com.example.autopayplugin.service.dto.request.contract;

import com.example.autopayplugin.service.dto.response.contract.ContractDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractGetRequestDTO {
    private Integer pageNumber;
    private Integer pageSize;
    private ContractDTO search;
}
