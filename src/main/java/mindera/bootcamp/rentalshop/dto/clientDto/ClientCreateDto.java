package mindera.bootcamp.rentalshop.dto.clientDto;

import jakarta.validation.constraints.*;
import mindera.bootcamp.rentalshop.utilMessages.Message;

import java.time.LocalDate;

public record ClientCreateDto(


        @NotNull(message = Message.BLANK_FIRSTNAME)
        @Size(max = 15)
        String firstName,
        @NotNull(message = Message.BLANK_LASTNAME)
        String lastName,
        @Email
        @NotNull(message = Message.BLANK_EMAIL)
        @Size(min = 10, max = 50)
        String email,
        @NotNull(message = Message.BLANK_DATEOFBIRTH)
        @Past(message = Message.INVALID_DATEOFBIRTH)
        LocalDate dateOfBirth,
        @NotNull(message = Message.BLANK_NIF)
       // @Size(min = 100000000, max = 999999999)
        Long nif,

        //@Size(min = 100000000, max = 999999999)
        @NotNull(message = Message.BLANK_DRIVERLICENSE)
        Long driverLicense

) {
}
