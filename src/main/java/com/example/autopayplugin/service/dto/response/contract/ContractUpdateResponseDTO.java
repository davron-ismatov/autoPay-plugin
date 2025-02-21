package com.example.autopayplugin.service.dto.response.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractUpdateResponseDTO {
    private String pinfl;
    private String loanId;
    private Long totalDebt;
    private Long currentDebt;
    private String ext;
    private String account;
    private String info;
}
