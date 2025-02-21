package com.example.autopayplugin.service.dto.response.transaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionSynchResponseDTO {
    @Schema(description = "Number of updates by given query")
    private Integer updated;

    @Schema(description = "Message of request")
    private Boolean isSynced;
}
