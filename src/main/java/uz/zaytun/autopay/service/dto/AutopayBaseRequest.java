package uz.zaytun.autopay.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AutopayBaseRequest<DTO> {
    private String method;
    private DTO params;
}
