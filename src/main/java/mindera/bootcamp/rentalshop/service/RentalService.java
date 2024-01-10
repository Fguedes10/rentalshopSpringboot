package mindera.bootcamp.rentalshop.service;

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

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRental(Long rentalId) {
        Optional<Rental> rentalOptional = rentalRepository.findById(rentalId);
        if(rentalOptional.isEmpty()){
            throw new IllegalStateException(Message.RENTAL_WITH_ID + rentalId + Message.NOT_EXISTS);
        }
        return rentalOptional.get();
    }

    public void addNewRental(Rental rental) {
        Optional<Rental> rentalOptional = this.rentalRepository.findByVehicleId(rental.getVehicle());
        if(rentalOptional.isPresent()){
            throw new IllegalStateException(Message.ALREADY_RENTED);
        }
        rentalRepository.save(rental);
    }

    public void deleteRental(Long rentalId) {
        Optional<Rental> deletedRental = rentalRepository.findById(rentalId);
        boolean exists = rentalRepository.existsById(rentalId);
        if(!exists){
            throw new IllegalStateException(Message.RENTAL_WITH_ID + rentalId + Message.NOT_EXISTS);
        }
        rentalRepository.delete(deletedRental.get());
    }

}
