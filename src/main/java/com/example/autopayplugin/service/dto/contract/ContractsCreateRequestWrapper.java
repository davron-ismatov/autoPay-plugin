package com.example.autopayplugin.service.dto.contract;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContractsCreateRequestWrapper {
    private List<ContractCreateDTO> contracts;
}
