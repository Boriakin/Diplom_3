package praktikum.api.apis;

import io.restassured.response.Response;
import praktikum.api.RequestSpec;
import praktikum.api.pojo.request.LoginRequest;
import praktikum.api.pojo.request.RegisterRequest;
import praktikum.api.pojo.response.RegisterAndLoginResponse;
import praktikum.api.wrapper.TypedResponse;

import static praktikum.constants.Urls.*;

public class UserApi {

    RequestSpec spec = new RequestSpec();

    public TypedResponse<RegisterAndLoginResponse> registerUser(RegisterRequest registerRequest) {
        Response response =
                spec.baseRequestSpec()
                        .basePath(REGISTER_PATH)
                        .body(registerRequest)
                        .post();
        return new TypedResponse<>(response, RegisterAndLoginResponse.class);
    }

    public String getToken(RegisterRequest registerRequest) {
        return registerUser(registerRequest).body().getAccessToken();
    }

    public TypedResponse<RegisterAndLoginResponse> loginUser(LoginRequest loginRequest) {
        Response response = spec.baseRequestSpec()
                .basePath(LOGIN_PATH)
                .body(loginRequest)
                .post();
        return new TypedResponse<>(response, RegisterAndLoginResponse.class);
    }

    public String getToken(LoginRequest loginRequest) {
        return loginUser(loginRequest).body().getAccessToken();
    }

    public void deleteUser(String token) {
        spec.baseRequestSpec(token)
                .basePath(USER_PATH)
                .delete();
    }
}
