package com.poc.vehicleapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Bike")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Bike extends Vehicle {

    private String subType;

}
