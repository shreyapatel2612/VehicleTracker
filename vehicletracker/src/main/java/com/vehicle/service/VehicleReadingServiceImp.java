package com.vehicle.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.entity.Vehicle;
import com.vehicle.entity.VehicleReading;
import com.vehicle.repository.VehicleReadingRepository;
import com.vehicle.repository.VehicleRepository;

@Service
public class VehicleReadingServiceImp implements VehicleReadingService{
	@Autowired
	VehicleReadingRepository vehicleReadingRepository;

	@Transactional
	public List<VehicleReading> findAll() {
		return (List<VehicleReading>)vehicleReadingRepository.findAll();
	}
	
	@Transactional
	public VehicleReading create(VehicleReading vehicleReading) {
		return vehicleReadingRepository.save(vehicleReading);
	}
}
