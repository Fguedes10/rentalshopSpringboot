package mindera.bootcamp.rentalshop.controller;

import mindera.bootcamp.rentalshop.entity.Client;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import mindera.bootcamp.rentalshop.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Vehicle>> getVehicles(){
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable("vehicleId") Long vehicleId){
        return new ResponseEntity<>(vehicleService.getVehicle(vehicleId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Vehicle> addNewVehicle(@RequestBody Vehicle vehicle){
        vehicleService.addNewVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> deleteVehicleById (@PathVariable("vehicleId") Long vehicleId, @RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.deleteVehicle(vehicleId), HttpStatus.OK);
    }

    @PatchMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> patchVehicleById(@PathVariable("vehicleId") Long vehicleId, @RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.patchVehicleById(vehicleId, vehicle), HttpStatus.OK);
    }

    @PutMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> putVehicleById(@PathVariable("vehicleId") Long vehicleId, @RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.putVehicleById(vehicleId, vehicle), HttpStatus.OK);
    }

}
