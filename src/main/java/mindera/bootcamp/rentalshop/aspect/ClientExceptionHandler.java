package mindera.bootcamp.rentalshop.aspect;

import jakarta.servlet.http.HttpServletRequest;
import mindera.bootcamp.rentalshop.Exception.ClientException.ClientAlreadyExistsException;
import mindera.bootcamp.rentalshop.Exception.ClientException.ClientNotFoundException;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Aspect
@ControllerAdvice
public class ClientExceptionHandler {


/*    @ExceptionHandler(value = {
            ClientNotFoundException.class,
            ClientAlreadyExistsException.class})
    public ResponseEntity<String> clientHandler(Exception ex, HttpServletRequest request){

    }*/


}
