package newthread.server.backend.Utils;


import lombok.Getter;

@Getter
public class BaseResponse<T> {
    private final T result;
    private final String description;

    public BaseResponse(T result, String description) {
        this.result = result;
        this.description = description;
    }
}
