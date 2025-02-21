package uz.zaytun.autopay.service.dto.request.authorization;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorizationRequestDTO {
    @Schema(description = "Username must be filled in")
    private String username;

    @Schema(description = "Password must be filled in")
    private String password;

    @Schema(description = "The generated token is used for authenticating all other API requests.\n" +
            "If token send by partner system set this token as generated token for auth")
    private String token;
}
