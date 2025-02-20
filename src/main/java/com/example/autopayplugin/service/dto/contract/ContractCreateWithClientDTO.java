package com.example.autopayplugin.service.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ContractCreateWithClientDTO extends ContractCreateDTO {
    private Boolean auto;
    private String passport;
    private String firstName;
    private String lastName;
    private String middleName;
}
