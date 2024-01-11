package mindera.bootcamp.rentalshop.converter;

import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.entity.Vehicle;

public class VehicleConverter {


    public static VehicleCreateDto fromEntityToDto(Vehicle vehicle){
        return new VehicleCreateDto(
                vehicle.getBrand(),
                vehicle.getPlateNumber(),
                vehicle.getColor(),
                vehicle.getCubicCapacity(),
                vehicle.getHorsePower(),
                vehicle.getNumberOfSeats(),
                vehicle.getMileage(),
                vehicle.getPlateRegistrationDate(),
                vehicle.getDailyPrice()
        );
    }

    public static Vehicle fromDtoToEntity(VehicleCreateDto vehicleCreateDto){
        return Vehicle.builder()
                .brand(vehicleCreateDto.brand())
                .plateNumber(vehicleCreateDto.plateNumber())
                .color(vehicleCreateDto.color())
                .cubicCapacity(vehicleCreateDto.cubicCapacity())
                .horsePower(vehicleCreateDto.horsePower())
                .numberOfSeats(vehicleCreateDto.numberOfSeats())
                .mileage(vehicleCreateDto.mileage())
                .plateRegistrationDate(vehicleCreateDto.plateRegistrationDate())
                .dailyPrice(vehicleCreateDto.dailyPrice()).build();
    }


}
