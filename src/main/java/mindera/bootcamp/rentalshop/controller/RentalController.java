package mindera.bootcamp.rentalshop.controller;

import jakarta.validation.Valid;
import mindera.bootcamp.rentalshop.Exception.ClientException.ClientNotFoundException;
import mindera.bootcamp.rentalshop.Exception.RentalException.RentalNotFoundException;
import mindera.bootcamp.rentalshop.Exception.VehicleException.VehicleNotFoundException;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalPatchDto;
import mindera.bootcamp.rentalshop.entity.Rental;
import mindera.bootcamp.rentalshop.service.RentalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/version1/rentals")
public class RentalController {

    private final RentalServiceImpl rentalServiceImpl;

    public RentalController(RentalServiceImpl rentalServiceImpl) {
        this.rentalServiceImpl = rentalServiceImpl;
    }

    @GetMapping("/")
    public ResponseEntity<List<RentalGetDto>> getRentals() {
        return new ResponseEntity<>(rentalServiceImpl.getRentals(), HttpStatus.OK);
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<RentalGetDto> getRental(@PathVariable("rentalId") Long rentalId) throws RentalNotFoundException {
        return new ResponseEntity<>(rentalServiceImpl.getRental(rentalId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RentalGetDto> addNewRental(@RequestBody RentalCreateDto rental) throws VehicleNotFoundException, ClientNotFoundException {
        return new ResponseEntity<>( rentalServiceImpl.addNewRental(rental), HttpStatus.CREATED);
    }

    @PatchMapping("/{rentalId}")
    public ResponseEntity<RentalGetDto> patchRental(@PathVariable("rentalId") Long rentalId,
                                                      @Valid @RequestBody RentalPatchDto rental) throws RentalNotFoundException {
        return new ResponseEntity<>(rentalServiceImpl.patchRental(rentalId, rental), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "{rentalId}")
    public ResponseEntity<Rental> deleteRentalById(@PathVariable("rentalId") Long rentalId) {
        rentalServiceImpl.deleteRental(rentalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
