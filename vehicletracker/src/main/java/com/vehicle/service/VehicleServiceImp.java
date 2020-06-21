package com.vehicle.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vehicle.entity.Vehicle;
import com.vehicle.repository.VehicleRepository;

@Service
public class VehicleServiceImp implements VehicleService{

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Transactional
	public List<Vehicle> findAll() {
		return (List<Vehicle>)vehicleRepository.findAll();
	}
	
	@Transactional
	public Vehicle create(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
}
