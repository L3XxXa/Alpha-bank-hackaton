package newthread.server.backend.Controller;

import newthread.server.backend.Exception.InvalidData;
import newthread.server.backend.Exception.UserAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArticleController {
    @ExceptionHandler({UserAlreadyExists.class, InvalidData.class})
    public <T extends RuntimeException> ResponseEntity<String> handleException(T e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
