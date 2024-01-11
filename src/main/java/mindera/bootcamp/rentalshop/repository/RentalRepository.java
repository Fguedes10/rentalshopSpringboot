package mindera.bootcamp.rentalshop.repository;

import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Rental;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    Optional<Rental> findByVehicleId(Vehicle vehicle);
    Optional<Rental> findByClientId(Client client);

}
