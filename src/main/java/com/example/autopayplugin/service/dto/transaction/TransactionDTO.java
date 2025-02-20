package com.example.autopayplugin.service.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Integer merchantId;
    private String pinfl;
    private String loanId;
    private String ext;
    private String rrn;
    private CardDTO card;
    private String status;
    private String processing;
    private String date;
    private Double amount;
    private String terminal;
    private String merchant;
    private Boolean isSynced;
    private String pushId;
    private Instant createdAt;
    private Instant updatedAt;
}
