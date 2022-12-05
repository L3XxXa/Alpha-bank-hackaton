package newthread.server.backend.Controller;

import newthread.server.backend.Exception.InvalidData;
import newthread.server.backend.Exception.NotFound;
import newthread.server.backend.Exception.UserAlreadyExists;
import newthread.server.backend.Utils.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArticleController {
    @ExceptionHandler({UserAlreadyExists.class, InvalidData.class, NotFound.class})
    public <T extends RuntimeException> ResponseEntity<BaseResponse<Boolean>> handleException(T e) {
        return new ResponseEntity<>(new BaseResponse<>(false,
                e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
