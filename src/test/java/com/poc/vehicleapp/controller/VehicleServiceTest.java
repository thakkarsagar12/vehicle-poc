package com.poc.vehicleapp.controller;

import com.poc.vehicleapp.dao.VehicleRepository;
import com.poc.vehicleapp.entity.Bike;
import com.poc.vehicleapp.entity.Vehicle;
import com.poc.vehicleapp.service.VehicleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VehicleService.class)
class VehicleServiceTest {

    private final String baseEndPoint = "/api/v1/vehicle";


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    VehicleService vehicleService;

    @MockBean
    VehicleRepository vehicleRepository ;



    @Test
    @DisplayName("Test to save vehicle!")
    void saveVehicleTest() {
        // Set up mock repository
        Vehicle vehicle =  Bike.builder()
                .name("Vespa")
                .brand("Piaggio")
                .maxSpeed(80.5f)
                .subType("Moped")
                .build();

//        doReturn(vehicle).when(vehicleRepository).save(vehicle);
        when(vehicleRepository.save(vehicle)).thenReturn(vehicle);


        // Execute the service call
        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);

        // Assert the response
        Assertions.assertNotNull(savedVehicle);
    }

    @Test
    @DisplayName("Test to get all vehicles!")
    void getAllVehicles() {
        // Set up mock repository
        Vehicle vehicle =  Bike.builder()
                .name("Vespa")
                .brand("Piaggio")
                .maxSpeed(80.5f)
                .subType("Moped")
                .build();

        List<Vehicle> vehicleList = Arrays.asList(vehicle);

        doReturn(vehicleList).when(vehicleRepository).findAll();


        // Execute the service call
        List<Vehicle> savedVehicleList = vehicleService.getAllVehicle();

        // Assert the response
        Assertions.assertNotNull(savedVehicleList);
        Assertions.assertEquals(1, savedVehicleList.size());
    }

}

