package mindera.bootcamp.rentalshop.controller;

import mindera.bootcamp.rentalshop.entity.Rental;
import mindera.bootcamp.rentalshop.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/version1/rentals")
public class RentalController {

    private final RentalService rentalService;
    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Rental>> getRentals(){
        return new ResponseEntity<>(rentalService.getRentals(), HttpStatus.OK);
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<Rental> getRentals(@PathVariable("rentalId") Long rentalId){
        return new ResponseEntity<>(rentalService.getRental(rentalId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Rental> addNewRental(@RequestBody Rental rental){
        rentalService.addNewRental(rental);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{rentalId}")
    public ResponseEntity<Rental> deleteRentalById (@PathVariable("rentalId") Long rentalId, @RequestBody Rental rental){
        return new ResponseEntity<>(rentalService.deleteRental(rentalId), HttpStatus.OK);
    }

}
