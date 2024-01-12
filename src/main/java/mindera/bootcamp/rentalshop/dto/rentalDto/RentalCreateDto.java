package mindera.bootcamp.rentalshop.dto.rentalDto;

import jakarta.validation.constraints.NotBlank;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Vehicle;

import java.time.LocalDate;

public record RentalCreateDto(
        @NotBlank(message = "Invalid vehicle")
        Long clientId,
        @NotBlank(message = "Invalid client")
        Long vehicleId,
        @NotBlank(message = "Invalid start date")
        LocalDate rentalStartDate,
        @NotBlank(message = "Invalid end date")
        LocalDate rentalEndDate

) {
}
