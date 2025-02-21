package uz.zaytun.autopay.service.dto.request.contract;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ContractCreateRequestDTO {
    @Schema(description = "Partners choose their own merchants")
    private Integer merchantId;

    @Schema(description = "The 14-digit PINFL of the client whose data is to be updated")
    private String pinfl;

    @Schema(description = "Loan ID, max 100 characters")
    private String loanId;

    @Schema(description = "Total debt amount")
    private String debt;

    @Schema(description = "Ext id information, max 255 characters")
    private String ext;

    @Schema(description = "Account information, max 255 characters")
    private String account;

    @Schema(description = "Additional details, max 255 characters  ")
    private String info;
}
