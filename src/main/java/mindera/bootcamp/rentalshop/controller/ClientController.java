package mindera.bootcamp.rentalshop.controller;

import jakarta.validation.Valid;
import mindera.bootcamp.rentalshop.Exception.ClientException.ClientAlreadyExistsException;
import mindera.bootcamp.rentalshop.Exception.ClientException.ClientNotFoundException;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientCreateDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientGetDto;
import mindera.bootcamp.rentalshop.dto.clientDto.ClientPatchDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/version1/clients")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @GetMapping("/")
    public ResponseEntity<List<ClientCreateDto>> getClients() {
        return new ResponseEntity<>(clientServiceImpl.getClients(), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientGetDto> getClient(@PathVariable("clientId") Long clientId) throws ClientNotFoundException {
            return new ResponseEntity<>(clientServiceImpl.getClient(clientId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ClientGetDto> addNewClient(@Valid @RequestBody ClientCreateDto client, BindingResult bindingResult) throws ClientAlreadyExistsException {
        if (bindingResult.hasErrors()) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(clientServiceImpl.addNewClient(client), HttpStatus.CREATED);
    }

   @DeleteMapping(path = "{clientId}")
    public ResponseEntity<Client> deleteClientById(@PathVariable("clientId") Long clientId) throws ClientNotFoundException {
        clientServiceImpl.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(path = "{clientId}")
    public ResponseEntity<ClientGetDto> patchClientById(@PathVariable("clientId") Long clientId, @Valid @RequestBody ClientPatchDto client, BindingResult bindingResult) throws ClientNotFoundException {
        if (bindingResult.hasErrors()) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(clientServiceImpl.patchClient(clientId, client), HttpStatus.OK);
    }

    @PutMapping(path = "{clientId}")
    public ResponseEntity<Client> putClientById(@PathVariable("clientId") Long clientId, @Valid @RequestBody Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clientServiceImpl.putClient(clientId, client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
