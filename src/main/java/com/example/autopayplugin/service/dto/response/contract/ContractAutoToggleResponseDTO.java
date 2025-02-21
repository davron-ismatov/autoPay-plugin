package com.example.autopayplugin.service.dto.response.contract;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractAutoToggleResponseDTO {
    @Schema(description = "Number of updated rows with your request")
    private Integer updated;

    private Boolean auto;
}
