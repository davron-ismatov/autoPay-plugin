package com.example.autopayplugin.service.dto.transaction;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionVerificationSetRequestDTO {
    private String host;
    private String token;
    private Boolean status;
    private Integer delay;
}
