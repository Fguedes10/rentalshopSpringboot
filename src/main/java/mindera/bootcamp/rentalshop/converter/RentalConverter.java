package mindera.bootcamp.rentalshop.converter;

import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RentalConverter {


    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "vehicle.id", target = "vehicleId")
    RentalCreateDto fromEntityToDto(Rental rental);



    RentalGetDto fromEntityToGetDto (Rental rental);

}
