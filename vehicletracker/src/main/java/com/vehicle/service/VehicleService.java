package com.vehicle.service;

import java.util.List;

import com.vehicle.entity.Vehicle;

public interface VehicleService {
	List<Vehicle> findAll();
	
	//Vehicle findOne(String vin);
	
	Vehicle create(Vehicle vehicle);
}
