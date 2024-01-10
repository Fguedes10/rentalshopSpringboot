package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import mindera.bootcamp.rentalshop.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicle(Long vehicleId) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if(vehicleOptional.isEmpty()){
            throw new IllegalStateException("The vehicle with " + vehicleId + " does not exist");
        }
        return vehicleOptional.get();
    }

    public void addNewVehicle(Vehicle vehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByPlateNumber(vehicle.getPlateNumber());
        if(vehicleOptional.isPresent()){
            throw new IllegalStateException("A vehicle with these plate number already exists.");
        }
        vehicleRepository.save(vehicle);
    }
    public Vehicle deleteVehicle(Long vehicleId) {
        Optional<Vehicle> deletedVehicle = vehicleRepository.findById(vehicleId);
        boolean exists = vehicleRepository.existsById(vehicleId);
        if(!exists){
            throw new IllegalStateException("The vehicle with " + vehicleId + " id does not exist");
        }
        return deletedVehicle.get();
    }

    public Vehicle patchVehicleById(Long vehicleId, Vehicle vehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if (!vehicleOptional.isPresent()) {
            throw new IllegalStateException("The vehicle with " + vehicleId + " id does not exist");
        }
        Vehicle vehicleToPatch = vehicleOptional.get();
        if (vehicle.getBrand() != null && !vehicle.getBrand().isEmpty() && !vehicle.getBrand().equals(vehicleToPatch.getBrand())) {
            vehicleToPatch.setBrand(vehicle.getBrand());
        }
        if (vehicle.getColor() != null && !vehicle.getColor().isEmpty() && !vehicle.getColor().equals(vehicleToPatch.getColor())) {
            vehicleToPatch.setColor(vehicle.getColor());
        }
        if (vehicle.getMileage() != null && !vehicle.getMileage().equals(vehicleToPatch.getMileage())) {
            vehicleToPatch.setMileage(vehicle.getMileage());
        }
        if (vehicle.getHorsePower() != null && !vehicle.getHorsePower().equals(vehicleToPatch.getHorsePower())) {
            vehicleToPatch.setHorsePower(vehicle.getHorsePower());
        }
        if (vehicle.getNumberOfSeats() != null && !vehicle.getNumberOfSeats().equals(vehicleToPatch.getNumberOfSeats())) {
            vehicleToPatch.setNumberOfSeats(vehicle.getNumberOfSeats());
        }
        if (vehicle.getPlateRegistrationDate() != null && !vehicle.getPlateRegistrationDate().equals(vehicleToPatch.getPlateRegistrationDate())) {
            vehicleToPatch.setPlateRegistrationDate(vehicle.getPlateRegistrationDate());
        }
        if (vehicle.getPlateNumber() != null && !vehicle.getPlateNumber().equals(vehicleToPatch.getPlateNumber())) {
            vehicleToPatch.setPlateNumber(vehicle.getPlateNumber());
        }
        if (vehicle.getCubicCapacity() != null && !vehicle.getCubicCapacity().equals(vehicleToPatch.getCubicCapacity())) {
            vehicleToPatch.setCubicCapacity(vehicle.getCubicCapacity());
        }
        if (vehicle.getDailyPrice() != null && !vehicle.getDailyPrice().equals(vehicleToPatch.getDailyPrice())) {
            vehicleToPatch.setDailyPrice(vehicle.getDailyPrice());
        }

        return vehicleRepository.save(vehicleToPatch);
    }

    public Vehicle putVehicleById(Long vehicleId, Vehicle vehicle) {
        vehicle.setId(vehicleId);
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if(vehicleOptional.isEmpty()){
            throw new IllegalStateException("The vehicle with " + vehicle + " id does not exist");
        }
        return vehicleRepository.save(vehicle);
    }
}


