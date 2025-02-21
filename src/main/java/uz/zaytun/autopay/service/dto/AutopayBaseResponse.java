package uz.zaytun.autopay.service.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AutopayBaseResponse<R> {
    private Boolean status;
    private R result;
    private ErrorResponseDTO error;
}
