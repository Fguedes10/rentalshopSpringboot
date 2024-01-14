package mindera.bootcamp.rentalshop.dto.rentalDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

public record RentalCreateDto(
        @NotNull(message = "Invalid vehicle")
        Long clientId,
        @NotNull(message = "Invalid client")
        Long vehicleId,
        @NotNull(message = "Invalid start date")
        LocalDate rentalStartDate,
        @NotNull(message = "Invalid end date")
        LocalDate rentalEndDate

) {
}
