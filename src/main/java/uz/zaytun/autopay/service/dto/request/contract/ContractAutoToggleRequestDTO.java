package uz.zaytun.autopay.service.dto.request.contract;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractAutoToggleRequestDTO {
    @Schema(description = "Status of auto which that you want to set")
    private Boolean auto;

    @Schema(description = "List of loan_ids to update auto")
    private List<String> loadIds;
}
