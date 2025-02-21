package com.example.autopayplugin.service.dto.response.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionGetResponseDTO {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer total;
    private Integer lastPage;
    private Integer currentPage;
    private List<TransactionDTO> data;
}
