package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.dto.clientDto.ClientCreateDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientGetDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientPatchDto;
import mindera.bootcamp.rentalshop.entity.Client;

import java.util.List;

public interface ClientService {

    List<ClientCreateDto> getClients();

    ClientGetDto getClient(Long clientId);

    void patchClient(Long clientId, ClientPatchDto client);

    void putClient(Long clientId, Client client);
}
