package mindera.bootcamp.rentalshop.mapper;

import mindera.bootcamp.rentalshop.dto.clientDto.ClientCreateDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientGetDto;
import mindera.bootcamp.rentalshop.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientCreateDto fromEntityToClientCreateDto(Client client);

    Client fromClientCreateDtoToEntity(ClientCreateDto clientCreateDto);

    ClientGetDto fromEntityToClientGetDto(Client client);

}
