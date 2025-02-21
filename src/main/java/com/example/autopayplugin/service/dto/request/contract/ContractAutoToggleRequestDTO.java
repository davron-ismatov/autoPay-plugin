package com.example.autopayplugin.service.dto.request.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractAutoToggleRequestDTO {
    private Boolean auto;
    private List<String> loadIds;
}
