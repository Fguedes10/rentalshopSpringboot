package mindera.bootcamp.rentalshop.dto.rentalDto;

import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Vehicle;

import java.time.LocalDate;

public record RentalCreateDto(

        Long vehicleId,
        Long clientId,
        LocalDate rentalStartDate,

        LocalDate rentalEndDate,

        Long totalRentalCost
) {
}
