package uz.zaytun.autopay.service.dto.request.contract;

import uz.zaytun.autopay.service.dto.response.contract.ContractDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractGetRequestDTO {
    @Schema(description = "The number of records to display per page. Maximum allowed value is 500")
    private Integer pageNumber;

    @Schema(description = "The current page number for pagination. Must be at least 1")
    private Integer pageSize;

    @Schema(description = """
            An optional set of search attributes for filtering contracts.
            attributes: pinfl, loan_id, total_debit,current_debit, paid_amount, ext, auto.
            """)
    private ContractDTO search;
}
