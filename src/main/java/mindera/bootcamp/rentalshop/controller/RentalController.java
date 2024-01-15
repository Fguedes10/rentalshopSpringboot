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
    @Autowired
    private RentalServiceImpl rentalServiceImpl;


    @GetMapping("/")
    public ResponseEntity<List<RentalCreateDto>> getRentals() {
        return new ResponseEntity<>(rentalServiceImpl.getRentals(), HttpStatus.OK);
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<RentalGetDto> getRental(@PathVariable("rentalId") Long rentalId) {
        try{
        return new ResponseEntity<>(rentalServiceImpl.getRental(rentalId), HttpStatus.OK);
        } catch (RentalNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Rental> addNewRental(@RequestBody RentalCreateDto rental) {
        try {
            rentalServiceImpl.addNewRental(rental);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (VehicleNotFoundException | ClientNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{rentalId}")
    public ResponseEntity<RentalPatchDto> patchRental(@PathVariable("rentalId") Long rentalId,
                                                      @Valid @RequestBody RentalPatchDto rental) {
        try {
            rentalServiceImpl.patchRental(rentalId, rental);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RentalNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

/*    @DeleteMapping(path = "{rentalId}")
    public ResponseEntity<Rental> deleteRentalById(@PathVariable("rentalId") Long rentalId) {
        rentalServiceImpl.deleteRental(rentalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

}
