package com.example.autopayplugin.service.dto.contract;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContractsCreateResponseWrapper {
    private List<ContractCreateSuccessResponseDTO> created;
}
