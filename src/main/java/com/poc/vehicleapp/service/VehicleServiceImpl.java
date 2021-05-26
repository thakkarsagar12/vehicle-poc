package com.poc.vehicleapp.service;

import com.poc.vehicleapp.dao.VehicleRepository;
import com.poc.vehicleapp.entity.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Service Implementation for managing the Vehicle.
 */
@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * save the vehicle.
     * @param vehicle - the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        log.info("Request to save Vehicle: {}", vehicle);
        return vehicleRepository.save(vehicle);
    }

    /**
     * delete the vehicle.
     * @param vehicle - the entity to delete.
     */
    @Override
    public void deleteVehicle(Vehicle vehicle) {
        log.info("Request to delete Vehicle : {}", vehicle);
        vehicleRepository.delete(vehicle);
    }

    /**
     * get list of vehicles.
     * @return list of vehicles.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicle() {
        log.info("Request to get all Vehicles");
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> findListOfVehicleByBrand(String vehicleBrand) {
        log.info("Request to get list of vehicle by brand: {}", vehicleBrand);
        return vehicleRepository.findVehicleByBrand(vehicleBrand);
    }

    @Override
    public List<Vehicle> findListOfVehicleByType(String type) {
        log.info("Request to get list of vehicle by type: {}", type);
        return vehicleRepository.findVehicleByType(type);
    }
}