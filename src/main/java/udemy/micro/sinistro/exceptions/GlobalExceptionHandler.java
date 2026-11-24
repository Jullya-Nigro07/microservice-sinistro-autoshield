package udemy.micro.sinistro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFound.class)
    public ResponseEntity<Map<String, Object>> handleDataNotFound(
            DataNotFound exception) {

        Map<String, Object> body = new HashMap<>();

        body.put("status", 404);
        body.put("error", "Not Found");
        body.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(body);
    }
}
