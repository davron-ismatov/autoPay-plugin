package uz.zaytun.autopay.service.dto.request.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionVerificationCheckRequestDTO {
    private String method;
}
