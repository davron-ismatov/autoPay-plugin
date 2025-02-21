package uz.zaytun.autopay.service.dto.request.contract;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractFindRequestDTO {
    @Schema(description = "Contract`s loan_id attribute")
    private String loanId;
}
