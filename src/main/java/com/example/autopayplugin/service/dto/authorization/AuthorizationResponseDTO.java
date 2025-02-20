package com.example.autopayplugin.service.dto.authorization;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationResponseDTO {
    private String token;
}
