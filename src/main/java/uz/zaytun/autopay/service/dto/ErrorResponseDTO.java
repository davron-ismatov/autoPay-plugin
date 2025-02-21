package uz.zaytun.autopay.service.dto;

import uz.zaytun.autopay.domain.enumeration.AutopayErrors;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ErrorResponseDTO {
    private String message;
    private AutopayErrors status;
}
