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


    private final VehicleServiceImpl vehicleServiceImpl;

    public VehicleController(VehicleServiceImpl vehicleServiceImpl) {
        this.vehicleServiceImpl = vehicleServiceImpl;
    }


    @GetMapping("/")
    public ResponseEntity<List<VehicleGetDto>> getVehicles() {
        return new ResponseEntity<>(vehicleServiceImpl.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleGetDto> getVehicle(@PathVariable("vehicleId") Long vehicleId) throws VehicleNotFoundException {
            return new ResponseEntity<>(vehicleServiceImpl.getVehicleDto(vehicleId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<VehicleGetDto> addNewVehicle(@Valid @RequestBody VehicleCreateDto vehicle, BindingResult bindingResult) throws VehiclePlateAlreadyExists {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(vehicleServiceImpl.addNewVehicle(vehicle), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> deleteVehicleById(@PathVariable("vehicleId") Long vehicleId) {
        vehicleServiceImpl.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(path = "{vehicleId}")
    public ResponseEntity<VehicleGetDto> patchVehicleById(@PathVariable("vehicleId") Long vehicleId, @Valid @RequestBody VehiclePatchDto vehicle, BindingResult bindingResult) throws VehicleNotFoundException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(vehicleServiceImpl.patchVehicle(vehicleId, vehicle), HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "{vehicleId}")
    public ResponseEntity<Vehicle> putVehicleById(@PathVariable("vehicleId") Long vehicleId, @RequestBody Vehicle vehicle) throws VehicleNotFoundException {
            return new ResponseEntity<>(vehicleServiceImpl.putVehicle(vehicleId, vehicle), HttpStatus.OK);
    }

}
