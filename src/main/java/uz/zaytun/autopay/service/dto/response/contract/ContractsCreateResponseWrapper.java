package uz.zaytun.autopay.service.dto.response.contract;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContractsCreateResponseWrapper {
    private List<ContractCreateSuccessResponseDTO> created;
}
