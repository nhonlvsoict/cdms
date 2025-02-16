import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // todo: write javadoc for this method
    /**
     * Global exception handler for all exceptions.
     * 
     * @param e the exception to handle
     * @return a response entity with the exception message and status code 500
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleGlobalException(Exception e, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return createResponseEntity(problemDetail, null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}