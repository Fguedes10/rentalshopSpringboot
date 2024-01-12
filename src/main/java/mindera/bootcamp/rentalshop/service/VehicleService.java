package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleGetDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehiclePatchDto;
import mindera.bootcamp.rentalshop.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<VehicleCreateDto> getVehicles();

    VehicleGetDto getVehicleDto(Long vehicleId);

    void patchVehicle(Long vehicleId, VehiclePatchDto vehicle);

    Vehicle putVehicle(Long vehicleId, Vehicle vehicle);
}
