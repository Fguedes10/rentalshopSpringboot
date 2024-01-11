package mindera.bootcamp.rentalshop.converter;

import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Rental;

public class RentalConverter {

    public static RentalCreateDto fromEntityToDto(Rental rental){
        return new RentalCreateDto(
                rental.getVehicle().getId(),
                rental.getClient().getId(),
                rental.getRentalStartDate(),
                rental.getRentalEndDate()
        );
    }

    public static Rental fromDtoToEntity(RentalCreateDto rentalCreateDto){
        return Rental.builder()
                .rentalStartDate(rentalCreateDto.rentalStartDate())
                .rentalEndDate(rentalCreateDto.rentalEndDate()).build();
    }
}
