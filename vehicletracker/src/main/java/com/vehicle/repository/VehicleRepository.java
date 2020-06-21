package com.vehicle.repository;

import org.springframework.data.repository.CrudRepository;

import com.vehicle.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, String>{}
