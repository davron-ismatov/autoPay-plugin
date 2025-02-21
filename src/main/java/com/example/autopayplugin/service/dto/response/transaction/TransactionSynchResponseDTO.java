package com.example.autopayplugin.service.dto.response.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionSynchResponseDTO {
    private Integer updated;
    private Boolean isSynced;
}
