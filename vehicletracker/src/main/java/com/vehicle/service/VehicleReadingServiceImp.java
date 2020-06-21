package com.vehicle.service;

import java.util.List;
import javax.transaction.Transactional;
import org.jeasy.rules.api.Facts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vehicle.entity.Vehicle;
import com.vehicle.entity.VehicleReading;
import com.vehicle.helper.AlertHelper;
import com.vehicle.helper.RuleHelper;
import com.vehicle.repository.AlertRepository;
import com.vehicle.repository.VehicleReadingRepository;
import com.vehicle.repository.VehicleRepository;

@Service
public class VehicleReadingServiceImp implements VehicleReadingService{
	@Autowired
	VehicleReadingRepository vehicleReadingRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	AlertRepository alertRepository;
	
	@Transactional
	public List<VehicleReading> findAll() {
		return (List<VehicleReading>)vehicleReadingRepository.findAll();
	}
	
	@Transactional
	public VehicleReading create(VehicleReading vehicleReading) {
		vehicleReading = vehicleReadingRepository.save(vehicleReading);
		Vehicle vehicle = vehicleRepository.findById(vehicleReading.getVin()).get();
		Facts facts = new Facts();
		facts.put(AlertHelper.VEHICLE, vehicle);
		facts.put(AlertHelper.VEHICLE_READING, vehicleReading);
		facts.put(AlertHelper.ALERT_REPOSITORY, alertRepository);
		RuleHelper.executeRules(facts);
		return vehicleReading;
	}
}
