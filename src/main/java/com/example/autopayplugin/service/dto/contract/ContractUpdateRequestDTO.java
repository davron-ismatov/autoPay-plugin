package com.example.autopayplugin.service.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractUpdateRequestDTO {
    private String loanId;
    private ContractUpdateDetails data;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ContractUpdateDetails {
        private Long debt;
        private String ext;
        private Boolean auto;
        private String account;
        private String info;
    }
}
