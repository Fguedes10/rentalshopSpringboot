package mindera.bootcamp.rentalshop.dto.clientDto;

import jakarta.validation.constraints.*;
import mindera.bootcamp.rentalshop.utilMessages.Message;

import java.time.LocalDate;

public record ClientCreateDto(

        @NotNull(message = Message.BLANK_FIRSTNAME)
        String firstName,
        @NotNull(message = Message.BLANK_LASTNAME)
        String lastName,
        @NotNull(message = Message.BLANK_EMAIL)
        String email,
        @NotNull(message = Message.BLANK_DATEOFBIRTH)
        @Past(message = Message.INVALID_DATEOFBIRTH)
        LocalDate dateOfBirth,
       // @Pattern(regexp = "/^\\d+$/", message = Message.INVALID_NIF)
       // @Size(min = 9, max = 9)
        @NotNull(message = Message.BLANK_NIF)
        Long nif,
       // @Pattern(regexp = "^[0-9]", message = Message.INVALID_DRIVERLICENSE)
        //@Size(min = 9, max = 9)
        @NotNull(message = Message.BLANK_DRIVERLICENSE)
        Long driverLicense,
        @NotNull(message = Message.BLANK_DAILY_PRICE)
        Long dailyPrice
) {
}
