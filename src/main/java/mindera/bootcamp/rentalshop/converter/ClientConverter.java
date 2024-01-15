package mindera.bootcamp.rentalshop.converter;

import mindera.bootcamp.rentalshop.dto.clientDto.ClientCreateDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientGetDto;
import mindera.bootcamp.rentalshop.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientConverter {


    ClientCreateDto fromEntityToClientCreateDto(Client client);

    Client fromClientCreateDtoToEntity(ClientCreateDto clientCreateDto);

    ClientGetDto fromEntityToClientGetDto(Client client);

    Client fromClientGetDtoToEntity(ClientGetDto clientGetDto);


}
