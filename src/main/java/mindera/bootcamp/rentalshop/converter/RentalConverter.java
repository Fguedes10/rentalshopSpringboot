package mindera.bootcamp.rentalshop.converter;

import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RentalConverter {


    RentalCreateDto fromEntityToDto(Rental rental);

    Rental fromDtoToEntity(RentalCreateDto rentalCreateDto);

    RentalGetDto fromEntityToGetDto (Rental rental);

    Rental fromEntityToGetDto (RentalGetDto rentalGetDto);
}
