package com.vehicle.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.entity.Alert;
import com.vehicle.entity.Vehicle;
import com.vehicle.entity.VehicleReading;
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
		Alert alert = new Alert();
		Vehicle vehicle = vehicleRepository.findById(vehicleReading.getVin()).get();
		
		
		alert.setTimestamp(vehicleReading.getTimestamp());
		alert.setVehicleReadingId(vehicleReading.getId());
		alert.setVin(vehicleReading.getVin());
		
		if (vehicleReading.getEngineRpm() > vehicle.getReadlineRpm()) {
			alert.setAlertType(Alert.ALERT_TYPE_HIGH);
			alert.setMessage("Engine rpm is greater than readline rpm");
		}
		if (vehicleReading.getFuelvolume() < (0.1 *vehicle.getMaxFuelVolume())) {
			alert.setAlertType(Alert.ALERT_TYPE_MEDIUM);
			alert.setMessage("Fuel volume is less than 10 percent of max fuel volume");
		}
		if (vehicleReading.getTires().getFrontLeft() < 32 || vehicleReading.getTires().getFrontLeft() > 36 || 
				vehicleReading.getTires().getFrontRight() < 32 || vehicleReading.getTires().getFrontRight() > 36 ||
				vehicleReading.getTires().getRearLeft() < 32 || vehicleReading.getTires().getRearLeft() > 36 || 
				vehicleReading.getTires().getFrontRight() < 32 || vehicleReading.getTires().getFrontRight() > 36) {
			alert.setAlertType(Alert.ALERT_TYPE_LOW);
			alert.setMessage("Tire pressure is not between 32psi to 36psi");
		}
		if (vehicleReading.isEngineCoolantLow() || vehicleReading.isCheckEngineLightOn()) {
			alert.setAlertType(Alert.ALERT_TYPE_LOW);
			alert.setMessage("Engine coolant is low or engine light is on");
		}
		alertRepository.save(alert);
		return vehicleReading;
	}
}
