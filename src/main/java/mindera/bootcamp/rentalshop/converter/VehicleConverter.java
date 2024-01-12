package mindera.bootcamp.rentalshop.converter;

import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleGetDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehiclePatchDto;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleConverter {


    VehicleCreateDto fromEntityToCreateDto(Vehicle vehicle);


    Vehicle fromCreateDtoToEntity(VehicleCreateDto vehicleCreateDto);



    VehicleGetDto fromEntityToGetDto(Vehicle vehicle);

    Vehicle fromGetDtoToEntity(VehicleGetDto vehicleGetDto);

    VehiclePatchDto fromEntityToPatchDto(Vehicle vehicle);

    Vehicle fromPatchDtoToEntity(VehiclePatchDto vehiclePatchDto);



}
