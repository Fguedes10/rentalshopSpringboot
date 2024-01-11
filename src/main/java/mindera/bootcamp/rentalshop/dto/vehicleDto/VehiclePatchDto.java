package mindera.bootcamp.rentalshop.dto.vehicleDto;

import jakarta.validation.constraints.NotBlank;
import mindera.bootcamp.rentalshop.utilMessages.Message;

public record VehiclePatchDto(
        @NotBlank(message = Message.BLANK_MILEAGE)
        Long mileage
) {

}
