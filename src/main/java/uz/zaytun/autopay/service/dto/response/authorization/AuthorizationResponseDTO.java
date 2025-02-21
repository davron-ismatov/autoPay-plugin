package uz.zaytun.autopay.service.dto.response.authorization;

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
