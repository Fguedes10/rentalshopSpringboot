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

    private final ClientServiceImpl clientServiceImpl;

    @Autowired
    public ClientController(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientCreateDto>> getClients() {
        return new ResponseEntity<>(clientServiceImpl.getClients(), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientGetDto> getClient(@PathVariable("clientId") Long clientId) {
        try{
        return new ResponseEntity<>(clientServiceImpl.getClient(clientId), HttpStatus.OK);
        } catch (ClientNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Client> addNewClient(@Valid @RequestBody ClientCreateDto client, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
        clientServiceImpl.addNewClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ClientAlreadyExistsException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

/*    @DeleteMapping(path = "{clientId}")
    public ResponseEntity<Client> deleteClientById(@PathVariable("clientId") Long clientId) {
        clientService.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @PatchMapping(path = "{clientId}")
    public ResponseEntity<ClientPatchDto> patchClientById(@PathVariable("clientId") Long clientId, @Valid @RequestBody ClientPatchDto client, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
        clientServiceImpl.patchClient(clientId, client);
        return new ResponseEntity<>(HttpStatus.OK);
        } catch (ClientNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "{clientId}")
    public ResponseEntity<Client> putClientById(@PathVariable("clientId") Long clientId,@Valid @RequestBody Client client, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clientServiceImpl.putClient(clientId, client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
