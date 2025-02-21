package com.example.autopayplugin.service.dto.request.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionSynchRequestDTO {
    private Boolean isSynced;
    private List<String> transactions;
}
