package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.Exception.ClientException.ClientNotFoundException;
import mindera.bootcamp.rentalshop.Exception.RentalException.RentalNotFoundException;
import mindera.bootcamp.rentalshop.Exception.VehicleException.VehicleNotFoundException;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalPatchDto;

import java.util.List;

public interface RentalService {


    List<RentalGetDto> getRentals();
    RentalGetDto getRental(Long rentalId) throws RentalNotFoundException;
    RentalGetDto patchRental(Long rentalId, RentalPatchDto rental) throws RentalNotFoundException;

    RentalGetDto addNewRental(RentalCreateDto rental) throws VehicleNotFoundException, ClientNotFoundException;

}
