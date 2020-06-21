package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Vehicle;
import com.vehicle.entity.VehicleReading;
import com.vehicle.service.VehicleReadingService;
import com.vehicle.service.VehicleService;

@RestController
@RequestMapping(value = "/vehicles")
@CrossOrigin
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	VehicleReadingService vehicleReadingService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vehicle> findAll() {
		return vehicleService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody List<Vehicle> vehicles) {
		for (Vehicle vehicle: vehicles) {
			vehicleService.create(vehicle);
		}
	}
}
