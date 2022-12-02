package newthread.server.backend.Utils;


import lombok.Getter;

@Getter
public class SuccessResponse<T> {
    private final T result;

    public SuccessResponse(T result) {
        this.result = result;
    }
}
