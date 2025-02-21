package com.example.autopayplugin.service.dto.request.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDeleteRequestDTO {
    private String pinfl;
    private String loanId;
}
