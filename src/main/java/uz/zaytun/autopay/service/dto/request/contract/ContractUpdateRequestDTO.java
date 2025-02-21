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
public class ContractUpdateRequestDTO {
    @Schema(description = "Loan ID, max 100 characters.")
    private String loanId;

    @Schema(description = "The data includes the fields that need to")
    private ContractUpdateDetails data;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ContractUpdateDetails {
        @Schema(description = "Total debt amount")
        private Long debt;

        @Schema(description = "Ext id information, max 255 characters")
        private String ext;

        @Schema(description = "Turn off and on transaction auto")
        private Boolean auto;

        @Schema(description = "Account information, max 255 characters")
        private String account;

        @Schema(description = "Additional details, max 255 characters")
        private String info;
    }
}
