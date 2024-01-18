package mindera.bootcamp.rentalshop.converter;


import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleGetDto;
import mindera.bootcamp.rentalshop.entity.Vehicle;


public class VehicleConverter {

    public static Vehicle fromCreateDtoToEntity(VehicleCreateDto vehicleCreateDto) {
        return Vehicle.builder()
                .brand(vehicleCreateDto.brand())
                .plateNumber(vehicleCreateDto.plateNumber())
                .color(vehicleCreateDto.color())
                .cubicCapacity(vehicleCreateDto.cubicCapacity())
                .horsePower(vehicleCreateDto.horsePower())
                .numberOfSeats(vehicleCreateDto.numberOfSeats())
                .mileage(vehicleCreateDto.mileage())
                .plateRegistrationDate(vehicleCreateDto.plateRegistrationDate())
                .dailyPrice(vehicleCreateDto.dailyPrice())
                .available(vehicleCreateDto.available())
                .build();
    }

    public static VehicleGetDto fromEntityToGetDto(Vehicle vehicle) {
        return new VehicleGetDto(
                vehicle.getBrand(),
                vehicle.getColor(),
                vehicle.getCubicCapacity(),
                vehicle.getHorsePower(),
                vehicle.getNumberOfSeats(),
                vehicle.getPlateRegistrationDate(),
                vehicle.getDailyPrice(),
                vehicle.isAvailable()
        );

    }
}
