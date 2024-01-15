package mindera.bootcamp.rentalshop.dto.rentalDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mindera.bootcamp.rentalshop.utilMessages.Message;


import java.time.LocalDate;

public record RentalCreateDto(
        @NotNull(message = Message.INVALID_CLIENT_ID)
        Long clientId,
        @NotNull(message = Message.INVALID_VEHICLE_ID)
        Long vehicleId,
        @NotNull(message = Message.INVALID_START_DATE)
        LocalDate rentalStartDate,
        @NotNull(message = Message.INVALID_END_DATE)
        LocalDate rentalEndDate

) {
}
