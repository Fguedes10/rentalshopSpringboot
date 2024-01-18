package mindera.bootcamp.rentalshop.dto.vehicleDto;

import jakarta.validation.constraints.*;
import mindera.bootcamp.rentalshop.utilMessages.Message;

import java.time.LocalDate;

public record VehicleCreateDto(

        @NotBlank(message = Message.BLANK_BRAND)
        String brand,
        @NotBlank(message = Message.BLANK_PLATE_NUMBER)
        String plateNumber,

        @NotBlank(message = Message.BLANK_COLOR)
        //@Pattern(regexp = "[0-9]", message = Message.INVALID_NUMBER_OF_SEATS)
        String color,

        @NotNull(message = Message.BLANK_CUBIC)
        Double cubicCapacity,

        @NotNull(message = Message.BLANK_HORSE_POWER)
        Integer horsePower,

        @NotNull(message = Message.BLANK_NUMBER_OF_SEATS)
        //@Size(min = 7, max = 7)
        //@Pattern(regexp = "^[0-9]", message = Message.INVALID_NUMBER_OF_SEATS)
        Integer numberOfSeats,
        @NotNull(message = Message.BLANK_MILEAGE)
        Long mileage,
        @NotNull(message = Message.BLANK_REGISTRATION_DATE)
        @Past(message = Message.INVALID_REGISTRATION_DATE)
        LocalDate plateRegistrationDate,

        @NotNull(message = Message.BLANK_DAILY_PRICE)
        //@Size(min = 4, max = 4)
        //@Pattern(regexp = "^[0-9]", message = Message.INVALID_DAILY_PRICE)
        Long dailyPrice,
        @NotNull
        boolean available
) {
}

