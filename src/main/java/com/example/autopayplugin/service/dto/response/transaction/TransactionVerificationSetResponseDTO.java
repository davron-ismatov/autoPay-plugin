package com.example.autopayplugin.service.dto.response.transaction;

import com.example.autopayplugin.service.dto.request.transaction.TransactionVerificationSetRequestDTO;
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
