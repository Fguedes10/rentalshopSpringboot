package mindera.bootcamp.rentalshop.dto.vehicleDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mindera.bootcamp.rentalshop.utilMessages.Message;

public record VehiclePatchDto(
        @NotNull(message = Message.BLANK_MILEAGE)
        Long mileage
) {

}
