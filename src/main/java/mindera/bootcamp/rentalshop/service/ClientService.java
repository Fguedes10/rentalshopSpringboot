package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.converter.ClientConverter;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientCreateDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientPatchDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.repository.ClientRepository;
import mindera.bootcamp.rentalshop.utilMessages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient(Long clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            throw new IllegalStateException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        return clientOptional.get();
    }

    public void addNewClient(ClientCreateDto client) {
        Optional<Client> clientOptional = this.clientRepository.findByEmail(client.email());
        if (clientOptional.isPresent()) {
            throw new IllegalStateException(Message.REPEATED_EMAIL_ERROR);
        }
        Client client1 = ClientConverter.fromDtoToEntity(client);
        clientRepository.save(client1);
    }

/*    public void deleteClient(Long clientId) {
        Optional<Client> deletedClient = clientRepository.findById(clientId);
        boolean exists = clientRepository.existsById(clientId);
        if (!exists) {
            throw new IllegalStateException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        clientRepository.delete(deletedClient.get());
    }*/

    public void patchClientById(Long clientId, ClientPatchDto client) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (!clientOptional.isPresent()) {
            throw new IllegalStateException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        Client clientToPatch = clientOptional.get();
        if (client.firstName() != null && !client.firstName().isEmpty() && !client.firstName().equals(clientToPatch.getFirstName())) {
            clientToPatch.setFirstName(client.firstName());
        }
        if (client.lastName() != null && !client.lastName().isEmpty() && !client.lastName().equals(clientToPatch.getLastName())) {
            clientToPatch.setLastName(client.lastName());
        }
        if (client.email() != null && !client.email().isEmpty() && !client.email().equals(clientToPatch.getEmail())) {
            clientToPatch.setEmail(client.email());
        }
         clientRepository.save(clientToPatch);
    }

    public void putClientById(Long clientId, Client client) {
        client.setId(clientId);
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            throw new IllegalStateException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        clientRepository.save(client);
    }
}