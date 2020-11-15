package pl.pjatk.gameplay.configuration.exceptionhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import pl.pjatk.gameplay.configuration.model.ApiError;


import java.util.Date;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> notFoundException(NoSuchElementException ex, WebRequest request){
        ApiError apiError = new ApiError(404, new Date(),ex.getMessage(),"Operation can not be processed.");
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
