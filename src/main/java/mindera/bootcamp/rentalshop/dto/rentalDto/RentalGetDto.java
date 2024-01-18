package mindera.bootcamp.rentalshop.dto.rentalDto;


import jakarta.validation.constraints.NotNull;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientGetDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleGetDto;
import java.time.LocalDate;

public record RentalGetDto(

        Long id,
        ClientGetDto client,
        VehicleGetDto vehicle,
        LocalDate rentalStartDate,
        LocalDate rentalEndDate,
        Long totalRentalCost

) {
}
