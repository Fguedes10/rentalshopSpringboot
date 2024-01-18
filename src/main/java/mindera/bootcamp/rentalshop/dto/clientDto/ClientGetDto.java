package mindera.bootcamp.rentalshop.dto.clientDto;

import jakarta.validation.constraints.NotBlank;
import mindera.bootcamp.rentalshop.utilMessages.Message;

import java.time.LocalDate;

public record ClientGetDto(

        String firstName,
        String lastName,
        String email,
        LocalDate dateOfBirth,
        Long nif,
        Long driverLicense

) {
}
