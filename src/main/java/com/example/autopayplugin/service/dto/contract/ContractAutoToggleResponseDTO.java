package com.example.autopayplugin.service.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractAutoToggleResponseDTO {
    private Integer updated;
    private Boolean auto;
}
