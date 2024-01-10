package mindera.bootcamp.rentalshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClientDto(
        @NotBlank(message = "Must have a First Name")
        String firstName,
        @NotBlank(message = "Must have a Last Name")
        String lastName,
        @NotBlank(message = "Must have a Email")
        String email,
        @Pattern(regexp = "/^\\d+$/", message = "Please input a valid NIF number")
        @Size(min = 9, max = 9)
        @NotBlank(message = "Must have a NIF")
        String nif,
        @NotBlank(message = "Must have a date of birth")
        @Past(message = "Must be a valid date of birth")
        LocalDate dateOfBirth,

        @Pattern(regexp = "^[0-9]", message = "Please input a valid NIF")
        @Size(min = 9, max = 9)
        @NotBlank(message = "Must have a Driver License number")
        String driverLicense
) {
}
