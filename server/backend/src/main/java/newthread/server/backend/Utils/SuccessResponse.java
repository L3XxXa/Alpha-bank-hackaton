package newthread.server.backend.Utils;


import lombok.Getter;

@Getter
public class SuccessResponse<T> {
    private final T result;
    private final String description;

    public SuccessResponse(T result, String description) {
        this.result = result;
        this.description = description;
    }
}
