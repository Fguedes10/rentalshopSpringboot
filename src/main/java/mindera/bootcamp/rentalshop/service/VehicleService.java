package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.Exception.VehicleException.VehicleNotFoundException;
import mindera.bootcamp.rentalshop.Exception.VehicleException.VehiclePlateAlreadyExists;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleGetDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehiclePatchDto;
import mindera.bootcamp.rentalshop.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<VehicleGetDto> getVehicles();

    VehicleGetDto getVehicleDto(Long vehicleId) throws VehicleNotFoundException;

    VehicleGetDto patchVehicle(Long vehicleId, VehiclePatchDto vehicle) throws VehicleNotFoundException;
    VehicleGetDto addNewVehicle(VehicleCreateDto vehicle) throws VehiclePlateAlreadyExists;

    Vehicle putVehicle(Long vehicleId, Vehicle vehicle) throws VehicleNotFoundException;
}
