package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.converter.VehicleConverter;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleGetDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehiclePatchDto;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import mindera.bootcamp.rentalshop.repository.VehicleRepository;
import mindera.bootcamp.rentalshop.utilMessages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleConverter vehicleConverter;

@Override
    public List<VehicleCreateDto> getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(vehicleConverter::fromEntityToCreateDto).toList();
    }

    public Vehicle getVehicle(Long vehicleId) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if (vehicleOptional.isEmpty()) {
            throw new IllegalStateException(Message.VEHICLE_WITH_ID + vehicleId + Message.NOT_EXISTS);
        }
        return vehicleOptional.get();
    }
    @Override
    public VehicleGetDto getVehicleDto(Long vehicleId) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if (vehicleOptional.isEmpty()) {
            throw new IllegalStateException(Message.VEHICLE_WITH_ID + vehicleId + Message.NOT_EXISTS);
        }
        return vehicleConverter.fromEntityToGetDto(vehicleOptional.get());
    }

    public void addNewVehicle(VehicleCreateDto vehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByPlateNumber(vehicle.plateNumber());
        if (vehicleOptional.isPresent()) {
            throw new IllegalStateException(Message.REPEATED_PLATE_ERROR);
        }
        Vehicle newVehicle = vehicleConverter.fromCreateDtoToEntity(vehicle);
        vehicleRepository.save(newVehicle);
    }


    @Override
    public void patchVehicle(Long vehicleId, VehiclePatchDto vehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if (!vehicleOptional.isPresent()) {
            throw new IllegalStateException(Message.VEHICLE_WITH_ID + vehicleId + Message.NOT_EXISTS);
        }
        Vehicle vehicleToPatch = vehicleOptional.get();
        if (vehicle.mileage() != null && !vehicle.mileage().equals(vehicleToPatch.getMileage())) {
            vehicleToPatch.setMileage(vehicle.mileage());
        }
        vehicleRepository.save(vehicleToPatch);
    }

    @Override
    public Vehicle putVehicle(Long vehicleId, Vehicle vehicle) {
        vehicle.setId(vehicleId);
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if (vehicleOptional.isEmpty()) {
            throw new IllegalStateException(Message.VEHICLE_WITH_ID + vehicleId + Message.NOT_EXISTS);
        }
        return vehicleRepository.save(vehicle);
    }


/*    public void deleteVehicle(Long vehicleId) {
        Optional<Vehicle> deletedVehicle = vehicleRepository.findById(vehicleId);
        boolean exists = vehicleRepository.existsById(vehicleId);
        if (!exists) {
            throw new IllegalStateException(Message.VEHICLE_WITH_ID + vehicleId + Message.NOT_EXISTS);
        }
        vehicleRepository.delete(deletedVehicle.get());
    }*/
}


