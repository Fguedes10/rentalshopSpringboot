package mindera.bootcamp.rentalshop.aspect;


import mindera.bootcamp.rentalshop.Exception.ClientException.ClientAlreadyExistsException;
import mindera.bootcamp.rentalshop.Exception.ClientException.ClientNotFoundException;
import mindera.bootcamp.rentalshop.Exception.RentalException.RentalNotFoundException;
import mindera.bootcamp.rentalshop.Exception.VehicleException.VehicleNotFoundException;
import mindera.bootcamp.rentalshop.Exception.VehicleException.VehiclePlateAlreadyExists;
import org.aspectj.lang.annotation.Aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@Aspect
@ControllerAdvice
public class ExceptionsHandler {


    private static final Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);


    @ExceptionHandler(value = {ClientNotFoundException.class, VehicleNotFoundException.class, RentalNotFoundException.class})
    public ResponseEntity<String> NotFoundHandler (Exception ex) {
        logger.error("Known Exception: " + ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(value = {ClientAlreadyExistsException.class, VehiclePlateAlreadyExists.class})
    public ResponseEntity<String> AlreadyExistsHandler (Exception ex) {
        logger.error("Known Exception: " + ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
