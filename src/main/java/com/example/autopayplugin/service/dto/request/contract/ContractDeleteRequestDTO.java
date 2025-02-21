package com.example.autopayplugin.service.dto.request.contract;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDeleteRequestDTO {
    @Schema(description = "The 14-digit PINFL of the client whose data is to be updated")
    private String pinfl;

    @Schema(description = "Contract`s loan_id")
    private String loanId;
}
