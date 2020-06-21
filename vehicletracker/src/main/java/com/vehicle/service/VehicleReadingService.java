package com.vehicle.service;

import java.util.List;
import com.vehicle.entity.VehicleReading;

public interface VehicleReadingService {
	
	List<VehicleReading> findAll();
	
	VehicleReading create(VehicleReading vehicle);
}
