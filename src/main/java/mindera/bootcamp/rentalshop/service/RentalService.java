package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;

import java.util.List;

public interface RentalService {


    List<RentalCreateDto> getRentals();
    RentalGetDto getRental(Long rentalId);


}
