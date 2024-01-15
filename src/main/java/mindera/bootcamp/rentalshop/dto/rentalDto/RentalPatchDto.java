package mindera.bootcamp.rentalshop.dto.rentalDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import mindera.bootcamp.rentalshop.utilMessages.Message;

import java.time.LocalDate;

public record RentalPatchDto(

        @Past(message = Message.INVALID_END_DATE)
        @NotNull(message = Message.INVALID_END_DATE)
        LocalDate rentalEndDate
) {
}
