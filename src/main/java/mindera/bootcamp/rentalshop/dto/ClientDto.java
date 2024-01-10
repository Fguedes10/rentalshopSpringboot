package mindera.bootcamp.rentalshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import mindera.bootcamp.rentalshop.utilMessages.Message;

import java.time.LocalDate;

public record ClientDto(
        @NotBlank(message = Message.BLANK_FIRSTNAME)
        String firstName,
        @NotBlank(message = Message.BLANK_LASTNAME)
        String lastName,
        @NotBlank(message = Message.BLANK_EMAIL)
        String email,
        @Pattern(regexp = "/^\\d+$/", message = Message.INVALID_NIF)
        @Size(min = 9, max = 9)
        @NotBlank(message = Message.BLANK_NIF)
        String nif,
        @NotBlank(message = Message.BLANK_DATEOFBIRTH)
        @Past(message = Message.INVALID_DATEOFBIRTH)
        LocalDate dateOfBirth,

        @Pattern(regexp = "^[0-9]", message = Message.INVALID_DRIVERLICENSE)
        @Size(min = 9, max = 9)
        @NotBlank(message = Message.BLANK_DRIVERLICENSE)
        String driverLicense
) {
}
