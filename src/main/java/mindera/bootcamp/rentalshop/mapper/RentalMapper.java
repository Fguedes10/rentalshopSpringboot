package mindera.bootcamp.rentalshop.mapper;

import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;
import mindera.bootcamp.rentalshop.entity.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentalMapper {

    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);


    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "vehicle.id", target = "vehicleId")
    RentalCreateDto fromEntityToDto(Rental rental);



    RentalGetDto fromEntityToGetDto (Rental rental);
}
