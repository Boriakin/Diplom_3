package praktikum.api.wrapper;

import io.restassured.response.Response;

public class TypedResponse<T> {

    private final Response response;
    private final Class<T> cls;

    public TypedResponse(final Response response, final Class<T> cls) {
        this.response = response;
        this.cls = cls;
    }

    public T body() {
        return response.as(cls);
    }
}
