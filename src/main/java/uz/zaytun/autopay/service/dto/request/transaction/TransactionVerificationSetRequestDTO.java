package uz.zaytun.autopay.service.dto.request.transaction;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionVerificationSetRequestDTO {
    @Schema(description = "Webhook endpoint")
    private String host;

    @Schema(description = "Token for authorization ")
    private String token;

    @Schema(description = "Status of verification, if false we do not send pre payment confirmation requests")
    private Boolean status;

    @Schema(description = """
            Delay seconds between prePayment requests among one contract, if \
            you set it 60 seconds we do not send prepayment confirmation while 60 from last request.""")
    private Integer delay;
}
