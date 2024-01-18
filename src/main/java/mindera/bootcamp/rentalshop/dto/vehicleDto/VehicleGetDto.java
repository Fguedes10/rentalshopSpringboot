package mindera.bootcamp.rentalshop.dto.vehicleDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import mindera.bootcamp.rentalshop.utilMessages.Message;

import java.time.LocalDate;

public record VehicleGetDto(

        String brand,

        String color,

        Double cubicCapacity,

        Integer horsePower,

        Integer numberOfSeats,

        LocalDate plateRegistrationDate,

        Long dailyPrice,

        boolean available
) {
}
