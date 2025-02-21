package com.example.autopayplugin.service.dto.request.transaction;

import com.example.autopayplugin.service.dto.response.transaction.TransactionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionGetRequestDTO {
    @Schema(description = "The current page number for pagination. Must be at least 1")
    private Integer pageNumber;

    @Schema(description = "The number of records to display per page. Maximum allowed value is 500")
    private Integer pageSize;

    @Schema(description = """
            An optional set of search attributes for filtering transactions.
            attributes: pinfl, merchant_id, loan_id, ext, rrn, amount, status, date, terminal, merchant.
            """)
    private TransactionDTO search;
}
