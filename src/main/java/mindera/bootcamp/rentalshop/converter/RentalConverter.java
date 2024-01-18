package mindera.bootcamp.rentalshop.converter;

import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Rental;
import mindera.bootcamp.rentalshop.entity.Vehicle;


public class RentalConverter {



    public static Rental fromCreateDtoToEntity(RentalCreateDto rentalCreateDto, Client client, Vehicle vehicle) {
        return Rental.builder()
                .vehicle(vehicle)
                .client(client)
                .rentalStartDate(rentalCreateDto.rentalStartDate())
                .rentalEndDate(rentalCreateDto.rentalEndDate())
                .build();
    }

    public static RentalGetDto fromEntityToGetDto (Rental rental){
        return new RentalGetDto(
                rental.getId(),
                ClientConverter.fromEntityToClientGetDto(rental.getClient()),
                VehicleConverter.fromEntityToGetDto(rental.getVehicle()),
                rental.getRentalStartDate(),
                rental.getRentalEndDate(),
                rental.getTotalRentalCost()
        );
    }
}
