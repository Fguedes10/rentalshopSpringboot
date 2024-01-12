package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.converter.ClientConverter;
import mindera.bootcamp.rentalshop.converter.RentalConverter;
import mindera.bootcamp.rentalshop.converter.VehicleConverter;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientGetDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Rental;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import mindera.bootcamp.rentalshop.repository.RentalRepository;
import mindera.bootcamp.rentalshop.utilMessages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private RentalConverter rentalConverter;
    @Autowired
    private ClientConverter clientConverter;

    @Override
    public List<RentalCreateDto> getRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.stream().map(rentalConverter::fromEntityToDto).toList();
    }

    @Override
    public RentalGetDto getRental(Long rentalId) {
        Optional<Rental> rentalOptional = rentalRepository.findById(rentalId);
        if (rentalOptional.isEmpty()) {
            throw new IllegalStateException(Message.RENTAL_WITH_ID + rentalId + Message.NOT_EXISTS);
        }
        return rentalConverter.fromEntityToGetDto(rentalOptional.get());
    }

    public void addNewRental(RentalCreateDto rental) {
        Vehicle vehicle = this.vehicleServiceImpl.getVehicle(rental.vehicleId());
        Client client = clientConverter.fromClientGetDtoToEntity(this.clientServiceImpl.getClient(rental.clientId()));
        Rental newRental = new Rental(client, vehicle);
        newRental.setRentalStartDate(rental.rentalStartDate());
        newRental.setRentalEndDate(rental.rentalEndDate());
        rentalRepository.save(newRental);
    }

/*    public void deleteRental(Long rentalId) {
        Optional<Rental> deletedRental = rentalRepository.findById(rentalId);
        boolean exists = rentalRepository.existsById(rentalId);
        if (!exists) {
            throw new IllegalStateException(Message.RENTAL_WITH_ID + rentalId + Message.NOT_EXISTS);
        }
        rentalRepository.delete(deletedRental.get());
    }*/

}
