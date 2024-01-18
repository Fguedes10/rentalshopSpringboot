package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.Exception.ClientException.ClientNotFoundException;
import mindera.bootcamp.rentalshop.Exception.RentalException.RentalNotFoundException;
import mindera.bootcamp.rentalshop.Exception.VehicleException.VehicleNotFoundException;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalPatchDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Rental;
import mindera.bootcamp.rentalshop.converter.RentalConverter;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import mindera.bootcamp.rentalshop.repository.RentalRepository;
import mindera.bootcamp.rentalshop.utilMessages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private VehicleServiceImpl vehicleServiceImpl;
    @Autowired
    private ClientServiceImpl clientServiceImpl;


    @Override
    public List<RentalGetDto> getRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.stream().map(RentalConverter::fromEntityToGetDto).toList();
    }

    @Override
    public RentalGetDto getRental(Long rentalId) throws RentalNotFoundException {
        Optional<Rental> rentalOptional = rentalRepository.findById(rentalId);
        if (rentalOptional.isEmpty()) {
            throw new RentalNotFoundException(Message.RENTAL_WITH_ID + rentalId + Message.NOT_EXISTS);
        }
        return RentalConverter.fromEntityToGetDto(rentalOptional.get());
    }


    @Override
    public RentalGetDto addNewRental(RentalCreateDto rental) throws VehicleNotFoundException, ClientNotFoundException {
        Rental rentalToSave = RentalConverter.fromCreateDtoToEntity(rental,
                clientServiceImpl.getClientFromId(rental.clientId()),
                vehicleServiceImpl.getVehicleFromId(rental.vehicleId()));
        rentalToSave.setTotalRentalCost(rentalToSave.getRentalStartDate(), rentalToSave.getRentalEndDate());
         rentalRepository.save(rentalToSave);
         return RentalConverter.fromEntityToGetDto(rentalToSave);
    }

    @Override
    public RentalGetDto patchRental(Long rentalId, RentalPatchDto rental) throws RentalNotFoundException {
        Optional<Rental> rentalOptional = rentalRepository.findById(rentalId);
        if (rentalOptional.isEmpty()) {
            throw new RentalNotFoundException(Message.RENTAL_WITH_ID + rentalId + Message.NOT_EXISTS);
        }
        Rental rentalToPatch = rentalOptional.get();
        if (rental.rentalEndDate() != null && !rental.rentalEndDate().equals(rentalToPatch.getRentalEndDate())) {
            rentalToPatch.setRentalEndDate(rental.rentalEndDate());
        }
        Rental rentalToSave = rentalRepository.save(rentalToPatch);
        return RentalConverter.fromEntityToGetDto(rentalToSave);
    }

   public void deleteRental(Long rentalId) {
        Optional<Rental> deletedRental = rentalRepository.findById(rentalId);
        boolean exists = rentalRepository.existsById(rentalId);
        if (!exists) {
            throw new IllegalStateException(Message.RENTAL_WITH_ID + rentalId + Message.NOT_EXISTS);
        }
        rentalRepository.delete(deletedRental.get());
    }

}
