package mindera.bootcamp.rentalshop.dto;

import java.time.LocalDate;

public record RentalDto(

        LocalDate rentalStartDate,

        LocalDate rentalEndDate,

        Long totalRentalCost
) {
}
