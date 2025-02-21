package com.example.autopayplugin.service.dto.response.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractFindResponseDTO {
    private Integer merchantId;
    private String pinfl;
    private String loanId;
    private Long totalDebt;
    private Long currentDebt;
    private Long paidAmount;
    private String ext;
    private Boolean auto;
    private Integer createdBy;
    private String account;
    private String info;
}
