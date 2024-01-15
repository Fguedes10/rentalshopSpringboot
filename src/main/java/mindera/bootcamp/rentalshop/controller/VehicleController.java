package mindera.bootcamp.rentalshop.controller;

import jakarta.validation.Valid;
import mindera.bootcamp.rentalshop.Exception.VehicleException.VehicleNotFoundException;
import mindera.bootcamp.rentalshop.Exception.VehicleException.VehiclePlateAlreadyExists;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleCreateDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehicleGetDto;
import mindera.bootcamp.rentalshop.dto.vehicleDto.VehiclePatchDto;
import mindera.bootcamp.rentalshop.entity.Vehicle;
import mindera.bootcamp.rentalshop.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/version1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleServiceImpl vehicleServiceImpl;


    @GetMapping("/")
    public ResponseEntity<List<VehicleGetDto>> getVehicles() {
        return new ResponseEntity<>(vehicleServiceImpl.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleGetDto> getVehicle(@PathVariable("vehicleId") Long vehicleId) {
        try {
            return new ResponseEntity<>(vehicleServiceImpl.getVehicleDto(vehicleId), HttpStatus.OK);
        } catch (VehicleNotFoundException e) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
    }

    @PostMapping("/")
    public ResponseEntity<Vehicle> addNewVehicle(@Valid @RequestBody VehicleCreateDto vehicle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            vehicleServiceImpl.addNewVehicle(vehicle);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (VehiclePlateAlreadyExists e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

/*    @DeleteMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> deleteVehicleById(@PathVariable("vehicleId") Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @PatchMapping(path = "{vehicleId}")
    public ResponseEntity<VehiclePatchDto> patchVehicleById(@PathVariable("vehicleId") Long vehicleId, @Valid @RequestBody VehiclePatchDto vehicle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            vehicleServiceImpl.patchVehicle(vehicleId, vehicle);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (VehicleNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> putVehicleById(@PathVariable("vehicleId") Long vehicleId, @RequestBody Vehicle vehicle) {
        try {
            return new ResponseEntity<>(vehicleServiceImpl.putVehicle(vehicleId, vehicle), HttpStatus.OK);
        } catch (VehicleNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
