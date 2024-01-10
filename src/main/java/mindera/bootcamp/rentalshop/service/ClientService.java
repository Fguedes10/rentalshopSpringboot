package mindera.bootcamp.rentalshop.service;

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

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = this.clientRepository.findByEmail(client.getEmail());
        if (clientOptional.isPresent()) {
            throw new IllegalStateException(Message.REPEATED_EMAIL_ERROR);
        }
        clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        Optional<Client> deletedClient = clientRepository.findById(clientId);
        boolean exists = clientRepository.existsById(clientId);
        if (!exists) {
            throw new IllegalStateException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        clientRepository.delete(deletedClient.get());
    }

    public Client patchClientById(Long clientId, Client client) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (!clientOptional.isPresent()) {
            throw new IllegalStateException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        Client clientToPatch = clientOptional.get();
        if (client.getFirstName() != null && !client.getFirstName().isEmpty() && !client.getFirstName().equals(clientToPatch.getFirstName())) {
            clientToPatch.setFirstName(client.getFirstName());
        }
        if (client.getLastName() != null && !client.getLastName().isEmpty() && !client.getLastName().equals(clientToPatch.getLastName())) {
            clientToPatch.setLastName(client.getLastName());
        }
        if (client.getEmail() != null && !client.getEmail().isEmpty() && !client.getEmail().equals(clientToPatch.getEmail())) {
            clientToPatch.setEmail(client.getEmail());
        }
        if (client.getDateOfBirth() != null && !client.getDateOfBirth().equals(clientToPatch.getDateOfBirth())) {
            clientToPatch.setDateOfBirth(client.getDateOfBirth());
        }
        if (client.getNif() != null && !client.getNif().equals(clientToPatch.getNif())) {
            clientToPatch.setNif(client.getNif());
        }
        if (client.getDriverLicense() != null && !client.getDriverLicense().equals(clientToPatch.getDriverLicense())) {
            clientToPatch.setDriverLicense(client.getDriverLicense());
        }
        return clientRepository.save(clientToPatch);
    }

    public Client putClientById(Long clientId, Client client) {
        client.setId(clientId);
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            throw new IllegalStateException(Message.CLIENT_WITH_ID + clientId + Message.NOT_EXISTS);
        }
        return clientRepository.save(client);
    }
}