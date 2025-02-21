package com.example.autopayplugin.service.dto;

import com.example.autopayplugin.domain.enumeration.AutopayErrors;
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
