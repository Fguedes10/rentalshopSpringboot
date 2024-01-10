package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.entity.Rental;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import mindera.bootcamp.rentalshop.repository.RentalRepository;
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
            throw new IllegalStateException("The rental with " + rentalId + " id does not exist");
        }
        return rentalOptional.get();
    }

    public void addNewRental(Rental rental) {
        Optional<Rental> rentalOptional = this.rentalRepository.findByVehicleId(rental.getVehicle());
        if(rentalOptional.isPresent()){
            throw new IllegalStateException("This vehicle is currently rented.");
        }
        rentalRepository.save(rental);
    }

    public Rental deleteRental(Long rentalId) {
        Optional<Rental> deletedRental = rentalRepository.findById(rentalId);
        boolean exists = rentalRepository.existsById(rentalId);
        if(!exists){
            throw new IllegalStateException("The rental with " + rentalId + " id does not exist");
        }
        return deletedRental.get();
    }

}
