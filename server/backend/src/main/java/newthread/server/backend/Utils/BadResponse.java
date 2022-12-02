package newthread.server.backend.Utils;

import lombok.Getter;

@Getter
public class BadResponse {
    private final String exceptionMessage;

    public BadResponse(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
