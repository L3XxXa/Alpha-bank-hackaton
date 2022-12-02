package newthread.server.backend.Utils;


public class SuccessResponse<T> {
    private final T result;

    public SuccessResponse(T result) {
        this.result = result;
    }
}
