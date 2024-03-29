package mindera.bootcamp.rentalshop.service;

import mindera.bootcamp.rentalshop.Exception.ClientException.ClientAlreadyExistsException;
import mindera.bootcamp.rentalshop.Exception.ClientException.ClientNotFoundException;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientCreateDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientGetDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientPatchDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.converter.ClientConverter;
import mindera.bootcamp.rentalshop.repository.ClientRepository;
import mindera.bootcamp.rentalshop.utilMessages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<ClientCreateDto> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(ClientConverter::fromEntityToClientCreateDto).toList();
    }

    @Override
    public ClientGetDto getClient(Long clientId) throws ClientNotFoundException {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            throw new ClientNotFoundException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        return ClientConverter.fromEntityToClientGetDto(clientOptional.get());
    }

    public Client getClientFromId(Long clientId) throws ClientNotFoundException {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            throw new ClientNotFoundException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        return (clientOptional.get());
    }
    @Override
    public ClientGetDto addNewClient(ClientCreateDto client) throws ClientAlreadyExistsException {
        Optional<Client> clientOptional = this.clientRepository.findByEmail(client.email());
        if (clientOptional.isPresent()) {
            throw new ClientAlreadyExistsException(Message.REPEATED_EMAIL_ERROR);
        }
        clientRepository.save(ClientConverter.fromClientCreateDtoToEntity(client));
        return ClientConverter.fromCreateDtoToGetDto(client);
    }

    public void deleteClient(Long clientId) throws ClientNotFoundException {
            Optional<Client> deletedClient = clientRepository.findById(clientId);
            boolean exists = clientRepository.existsById(clientId);
            if (!exists && deletedClient.isEmpty()) {
                throw new ClientNotFoundException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
            }
            clientRepository.delete(deletedClient.get());
        }
    @Override
    public ClientGetDto patchClient(Long clientId, ClientPatchDto client) throws ClientNotFoundException {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            throw new ClientNotFoundException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
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
        Client saved = clientRepository.save(clientToPatch);
        return ClientConverter.fromEntityToClientGetDto(saved);
    }

    @Override
    public void putClient(Long clientId, Client client) {
        client.setId(clientId);
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            throw new IllegalStateException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        clientRepository.save(client);
    }
}