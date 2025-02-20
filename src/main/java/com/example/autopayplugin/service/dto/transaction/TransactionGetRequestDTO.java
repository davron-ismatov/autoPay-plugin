package com.example.autopayplugin.service.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionGetRequestDTO {
    private Integer pageNumber;
    private Integer pageSize;
    private TransactionDTO search;
}
