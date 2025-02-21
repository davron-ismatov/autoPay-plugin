package com.example.autopayplugin.service.dto.response.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractDTO {
    private Integer id;
    private Integer partnerId;
    private Integer merchantId;
    private String pinfl;
    private String loanId;
    private Long totalDebt;
    private Long currentDebt;
    private Long paidAmount;
    private Boolean auto;
    private String processingUzcard;
    private String checkedUzcard;
    private String processingHumo;
    private String checkedHumo;
    private String ext;
    private String account;
    private String info;
    private String createdBy;
    private Instant createdAt;
    private Instant updatedAt;
}
