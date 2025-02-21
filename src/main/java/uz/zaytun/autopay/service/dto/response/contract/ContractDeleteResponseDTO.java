package uz.zaytun.autopay.service.dto.response.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractDeleteResponseDTO {
    private String message;
    private String loanId;
    private String pinfl;
}
