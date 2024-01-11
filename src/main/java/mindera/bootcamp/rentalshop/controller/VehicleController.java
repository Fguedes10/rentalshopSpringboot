package mindera.bootcamp.rentalshop.controller;

import jakarta.validation.Valid;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehiclePatchDto;
import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import mindera.bootcamp.rentalshop.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/version1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicle(@Valid @PathVariable("vehicleId") Long vehicleId, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        vehicleService.getVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Vehicle> addNewVehicle(@Valid @RequestBody VehicleCreateDto vehicle, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        vehicleService.addNewVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

/*    @DeleteMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> deleteVehicleById(@PathVariable("vehicleId") Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @PatchMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> patchVehicleById(@PathVariable("vehicleId") Long vehicleId, @Valid @RequestBody VehiclePatchDto vehicle, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        vehicleService.patchVehicleById(vehicleId, vehicle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> putVehicleById(@PathVariable("vehicleId") Long vehicleId, @RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleService.putVehicleById(vehicleId, vehicle), HttpStatus.OK);
    }

}
