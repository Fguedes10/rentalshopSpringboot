package mindera.bootcamp.rentalshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import mindera.bootcamp.rentalshop.utilMessages.Message;

import java.time.LocalDate;

public record VehicleDto(


        @NotBlank(message = Message.BLANK_BRAND)
        String brand,
        @NotBlank(message = Message.BLANK_PLATE_NUMBER)
        String plateNumber,

        @NotBlank(message = Message.BLANK_COLOR)
        @Pattern(regexp = "[0-9]", message = Message.INVALID_NUMBER_OF_SEATS)
        String color,

        @NotBlank(message = Message.BLANK_CUBIC)
        Double cubicCapacity,

        @NotBlank(message = Message.BLANK_HORSE_POWER)
        Integer horsePower,

        @NotBlank(message = Message.BLANK_NUMBER_OF_SEATS)
        @Size(min = 7, max = 7)
        @Pattern(regexp = "^[0-9]", message = Message.INVALID_NUMBER_OF_SEATS)
        Integer numberOfSeats,
        @NotBlank(message = Message.BLANK_MILEAGE)
        Long mileage,
        @NotBlank(message = Message.BLANK_REGISTRATION_DATE)
        @Past(message = Message.INVALID_REGISTRATION_DATE)
        LocalDate plateRegistrationDate,

        @NotBlank(message = Message.BLANK_DAILY_PRICE)
        @Size(min = 4, max = 4)
        @Pattern(regexp = "^[0-9]", message = Message.INVALID_DAILY_PRICE)
        Long dailyPrice
) {
}

