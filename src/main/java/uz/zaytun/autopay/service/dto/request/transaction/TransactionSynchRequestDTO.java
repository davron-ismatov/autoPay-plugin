package uz.zaytun.autopay.service.dto.request.transaction;

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
public class TransactionSynchRequestDTO {
    @Schema(description = "Synchronized status of transactions list. true or false")
    private Boolean isSynced;

    @Schema(description = "Array of transaction ext values")
    private List<String> transactions;
}
