package mindera.bootcamp.rentalshop.controller;

import mindera.bootcamp.rentalshop.Exception.VehicleException.VehicleNotFoundException;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalCreateDto;
import mindera.bootcamp.rentalshop.dto.rentalDto.RentalGetDto;
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

    @Autowired
    public RentalController(RentalServiceImpl rentalServiceImpl) {
        this.rentalServiceImpl = rentalServiceImpl;
    }

    @GetMapping("/")
    public ResponseEntity<List<RentalCreateDto>> getRentals() {
        return new ResponseEntity<>(rentalServiceImpl.getRentals(), HttpStatus.OK);
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<RentalGetDto> getRental(@PathVariable("rentalId") Long rentalId) {
        return new ResponseEntity<>(rentalServiceImpl.getRental(rentalId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Rental> addNewRental(@RequestBody RentalCreateDto rental) {
        try{
        rentalServiceImpl.addNewRental(rental);
        return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (VehicleNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

/*    @DeleteMapping(path = "{rentalId}")
    public ResponseEntity<Rental> deleteRentalById(@PathVariable("rentalId") Long rentalId) {
        rentalServiceImpl.deleteRental(rentalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

}
