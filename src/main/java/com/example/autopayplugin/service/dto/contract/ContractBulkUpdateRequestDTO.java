package com.example.autopayplugin.service.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractBulkUpdateRequestDTO {
    private List<ContractUpdateRequestDTO> updates;
}
