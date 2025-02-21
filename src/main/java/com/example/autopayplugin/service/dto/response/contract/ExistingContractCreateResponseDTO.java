package com.example.autopayplugin.service.dto.response.contract;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExistingContractCreateResponseDTO {
    private List<String> created;
    private List<String> existingLoans;
    private List<String> notFoundClients;
    private List<String> duplicatedLoans;
}
