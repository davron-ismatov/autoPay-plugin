package com.example.autopayplugin.service.dto.request.authorization;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorizationRequestDTO {
    private String username;
    private String password;
    private String token;
}
