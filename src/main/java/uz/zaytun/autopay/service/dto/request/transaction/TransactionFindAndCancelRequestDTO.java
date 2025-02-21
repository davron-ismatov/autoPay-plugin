package uz.zaytun.autopay.service.dto.request.transaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFindAndCancelRequestDTO {
    @Schema(description = "Transaction`s ext number")
    private String ext;
}
