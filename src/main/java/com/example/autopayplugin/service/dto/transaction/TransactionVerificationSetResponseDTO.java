package com.example.autopayplugin.service.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TransactionVerificationSetResponseDTO extends TransactionVerificationSetRequestDTO {
    private String message;
}
