package com.example.autopayplugin.service.dto.contract;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class ContractCreateSuccessResponseDTO {
    private Integer merchantId;
    private String pinfl;
    private String loanId;
    private Long totalDebt;
    private Long currentDebt;
    private Long paidAmount;
    private String ext;
    private String account;
    private String info;
    private Boolean auto;
    private Integer partnerId;
    private Instant createdAt;
    private Instant updatedAt;
}
