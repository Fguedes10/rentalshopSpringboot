package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.converter.VehicleConverter;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
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
public class RentalService {

    private final RentalRepository rentalRepository;

    private final VehicleService vehicleService;
    private final ClientService clientService;

    @Autowired
    public RentalService(RentalRepository rentalRepository, VehicleService vehicleService, ClientService clientService) {
        this.rentalRepository = rentalRepository;
        this.vehicleService = vehicleService;
        this.clientService = clientService;
    }

    public List<Rental> getRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRental(Long rentalId) {
        Optional<Rental> rentalOptional = rentalRepository.findById(rentalId);
        if (rentalOptional.isEmpty()) {
            throw new IllegalStateException(Message.RENTAL_WITH_ID + rentalId + Message.NOT_EXISTS);
        }
        return rentalOptional.get();
    }

    public void addNewRental(RentalCreateDto rental) {
        Vehicle vehicle = this.vehicleService.getVehicle(rental.vehicleId());
        Client client = this.clientService.getClient(rental.clientId());
        Rental rental1 = new Rental(vehicle, client);
        rentalRepository.save(rental1);
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
