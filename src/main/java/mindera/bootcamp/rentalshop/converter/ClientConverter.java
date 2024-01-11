package mindera.bootcamp.rentalshop.converter;

import mindera.bootcamp.rentalshop.dto.clientDto.ClientCreateDto;
import mindera.bootcamp.rentalshop.entity.Client;

public class ClientConverter {


    public static ClientCreateDto fromEntityToDto(Client client){
        return new ClientCreateDto(
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getDateOfBirth(),
                client.getNif(),
                client.getDriverLicense()
                );
    }


    public static Client fromDtoToEntity(ClientCreateDto clientCreateDto) {
        return Client.builder()
                .firstName(clientCreateDto.firstName())
                .lastName(clientCreateDto.lastName())
                .email(clientCreateDto.email())
                .dateOfBirth(clientCreateDto.dateOfBirth())
                .nif(clientCreateDto.nif())
                .driverLicense(clientCreateDto.driverLicense()).build();
    }
}
