package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Vehicle;
import com.vehicle.service.VehicleService;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vehicle> findAll() {
		return vehicleService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody List<Vehicle> vehicles) {
		System.out.println("Request---------------------------------");
		for (Vehicle vehicle: vehicles) {
			vehicleService.create(vehicle);
		}
		 
	}
}
