package com.example.autopayplugin.service.dto.contract;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractCreateWithClientResponseDTO {
    private String message;
    private String loanId;
    private String pinfl;
}
