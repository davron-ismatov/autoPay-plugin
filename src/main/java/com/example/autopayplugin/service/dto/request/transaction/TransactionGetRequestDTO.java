package com.example.autopayplugin.service.dto.request.transaction;

import com.example.autopayplugin.service.dto.response.transaction.TransactionDTO;
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
