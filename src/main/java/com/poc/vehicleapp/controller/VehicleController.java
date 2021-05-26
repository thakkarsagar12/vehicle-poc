package com.poc.vehicleapp.controller;


import com.poc.vehicleapp.config.ConstantMessages;
import com.poc.vehicleapp.entity.Bike;
import com.poc.vehicleapp.entity.Car;
import com.poc.vehicleapp.entity.Vehicle;
import com.poc.vehicleapp.service.VehicleService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/vehicle")
@Slf4j
public class VehicleController {

    private final VehicleService vehicleService;
    private final ModelMapper modelMapper;

    public VehicleController(VehicleService vehicleService, ModelMapper modelMapper) {
        this.vehicleService = vehicleService;
        this.modelMapper = modelMapper;
    }

    /**
     * To get list of vehicles.
     * @return List of Vehicles.
     */
    @GetMapping
    public ResponseEntity<?> getAllVehicles() {
        return ResponseEntity.ok().body(CompletableFuture.completedFuture(vehicleService.getAllVehicle()));
    }

    /**
     * to save entity.
     * @param vehicle is a entity.
     * @return saved entity.
     */
    @PostMapping
    public ResponseEntity<?> saveVehicle(@RequestBody() Vehicle vehicle) {
        Bike bike;
        Car car;
        CompletableFuture<?> completableFuture = null;
        try {
            if (vehicle.getType().equals("Bike")) {
                bike = modelMapper.map(vehicle, Bike.class);
                completableFuture= CompletableFuture.completedFuture(vehicleService.saveVehicle(bike));
            }else if (vehicle.getType().equals("Car")) {
                car = modelMapper.map(vehicle, Car.class);
                completableFuture =CompletableFuture.completedFuture(vehicleService.saveVehicle(car));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ConstantMessages.NOT_VALID_JSON);
        }
        return ResponseEntity.ok().body(completableFuture);
    }

    /**
     *  to get list of vehicle of specific brand.
     * @param brandName - of the vehicle.
     * @return list of vehicle matches the brand name;
     */
    @GetMapping("/byBrand/{brandName}")
    public ResponseEntity<?> getAllVehiclesByBrand(@PathVariable("brandName") String brandName) {
        return ResponseEntity.ok().body(CompletableFuture.completedFuture(vehicleService.findListOfVehicleByBrand(brandName)));
    }


    @GetMapping("/byTypes/{type}")
    public ResponseEntity<?> getAllVehicleByTypes(@PathVariable("type") String type) {
        return ResponseEntity.ok().body(CompletableFuture.completedFuture(vehicleService.findListOfVehicleByType(type)));
    }





}
