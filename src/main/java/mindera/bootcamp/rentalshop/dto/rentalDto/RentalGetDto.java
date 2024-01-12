package mindera.bootcamp.rentalshop.dto.rentalDto;


import jakarta.validation.constraints.NotNull;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientGetDto;

import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleGetDto;

import java.time.LocalDate;

public record RentalGetDto(

        @NotNull(message = "Invalid client")
        ClientGetDto client,
        @NotNull(message = "Invalid vehicle")
        VehicleGetDto vehicle,
        @NotNull(message = "Invalid start date")
        LocalDate rentalStartDate,
        @NotNull(message = "Invalid end date")
        LocalDate rentalEndDate

) {
}
