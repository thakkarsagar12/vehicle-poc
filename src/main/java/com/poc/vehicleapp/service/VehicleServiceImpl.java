package com.poc.vehicleapp.service;

import com.poc.vehicleapp.dao.VehicleRepository;
import com.poc.vehicleapp.entity.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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

    /**
     * get list of vehicles by brand.
     * @param vehicleBrand - name of brand.
     * @return list of vehicles.
     */
    @Override
    public List<Vehicle> findListOfVehicleByBrand(String vehicleBrand) {
        log.info("Request to get list of vehicle by brand: {}", vehicleBrand);
        return vehicleRepository.findVehicleByBrand(vehicleBrand);
    }

    /**
     * get list of vehicle by type.
     * @param type - of vehicle.
     * @return list of vehicles.
     */
    @Override
    public List<Vehicle> findListOfVehicleByType(String type) {
        log.info("Request to get list of vehicle by type: {}", type);
        return vehicleRepository.findVehicleByType(type);
    }

    /**
     * find vehicle by id.
     * @param id - of the vehicle.
     * @return vehicle entity.
     */
    @Override
    public Optional<Vehicle> findById(Long id) {
        log.info("Request to get vehicle by id: {}", id);
        return vehicleRepository.findById(id);
    }
}
