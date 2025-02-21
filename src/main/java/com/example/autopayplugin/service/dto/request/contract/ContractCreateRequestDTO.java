package com.example.autopayplugin.service.dto.request.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ContractCreateRequestDTO {
    private Integer merchantId;
    private String pinfl;
    private String loanId;
    private String debt;
    private String ext;
    private String account;
    private String info;
}
