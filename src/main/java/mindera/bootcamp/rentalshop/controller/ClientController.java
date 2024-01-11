package mindera.bootcamp.rentalshop.controller;

import mindera.bootcamp.rentalshop.dto.clientDto.ClientCreateDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientPatchDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/version1/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClient(@PathVariable("clientId") Long clientId) {
        return new ResponseEntity<>(clientService.getClient(clientId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Client> addNewClient(@RequestBody ClientCreateDto client) {
        clientService.addNewClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{clientId}")
    public ResponseEntity<Client> deleteClientById(@PathVariable("clientId") Long clientId) {
        clientService.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(path = "{clientId}")
    public ResponseEntity<Client> patchClientById(@PathVariable("clientId") Long clientId, @RequestBody ClientPatchDto client) {
        return new ResponseEntity<>(clientService.patchClientById(clientId, client), HttpStatus.OK);
    }

    @PutMapping(path = "{clientId}")
    public ResponseEntity<Client> putClientById(@PathVariable("clientId") Long clientId, @RequestBody Client client) {
        clientService.putClientById(clientId, client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
