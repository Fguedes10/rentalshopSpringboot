package mindera.bootcamp.rentalshop.converter;

import mindera.bootcamp.rentalshop.dto.clientDto.ClientCreateDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientGetDto;
import mindera.bootcamp.rentalshop.entity.Client;

import java.time.LocalDate;

public class ClientConverter {


    public static ClientCreateDto fromEntityToClientCreateDto(Client client){
        return new ClientCreateDto(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getDateOfBirth(),
                client.getNif(),
                client.getDriverLicense()
        );

    }

    public static Client fromClientCreateDtoToEntity(ClientCreateDto clientCreateDto) {
        return Client.builder()
                .firstName(clientCreateDto.firstName())
                .lastName(clientCreateDto.lastName())
                .email(clientCreateDto.email())
                .dateOfBirth(clientCreateDto.dateOfBirth())
                .nif(clientCreateDto.nif())
                .driverLicense(clientCreateDto.driverLicense())
                .build();
    }

    public static ClientGetDto fromEntityToClientGetDto(Client client) {
        return new ClientGetDto(
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getDateOfBirth(),
                client.getNif(),
                client.getDriverLicense()
        );

    }

    public static ClientGetDto fromCreateDtoToGetDto(ClientCreateDto clientCreateDto){
       Client tempClient = fromClientCreateDtoToEntity(clientCreateDto);
       return fromEntityToClientGetDto(tempClient);
    }


}
