package com.poc.vehicleapp.dao;

import com.poc.vehicleapp.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findVehicleByBrand(String brand);

    List<Vehicle> findVehicleByType(String type);

}
