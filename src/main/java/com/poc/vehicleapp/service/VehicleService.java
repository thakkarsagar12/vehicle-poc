package com.poc.vehicleapp.service;

import com.poc.vehicleapp.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    Vehicle saveVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicle();

    List<Vehicle> findListOfVehicleByBrand(String vehicleBrand);

    List<Vehicle> findListOfVehicleByType(String type);

    Optional<Vehicle> findById(Long id);
}
