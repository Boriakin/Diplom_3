package praktikum.api.pojo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAndLoginResponse {

    private boolean success;
    private User user;
    private String accessToken;
    private String refreshToken;
}
