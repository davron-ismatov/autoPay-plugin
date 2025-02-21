package uz.zaytun.autopay.service.dto.response.transaction;

import uz.zaytun.autopay.service.dto.request.transaction.TransactionVerificationSetRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TransactionVerificationSetResponseDTO extends TransactionVerificationSetRequestDTO {
    private String message;
}
