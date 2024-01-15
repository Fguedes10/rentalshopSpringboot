package mindera.bootcamp.rentalshop.mapper;

import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleGetDto;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {

    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);


    Vehicle fromCreateDtoToEntity(VehicleCreateDto vehicleCreateDto);

    VehicleGetDto fromEntityToGetDto(Vehicle vehicle);
}
