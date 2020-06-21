package com.vehicle.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@Id
	String vin;
	String make;
	String model;
	int year;
	int readlineRpm;
	int maxFuelVolume;
	String lastServiceDate;

 	//@OneToMany(mappedBy="vehicles", cascade=CascadeType.ALL, fetch=FetchType.LAZY)//, cascade={javax.persistence.CascadeType.ALL})
	//@JoinColumn(name = "vin")//, nullable=false, insertable=false, updatable=false)
	//@OneToMany
	//List<VehicleReading> vehicleReadings;
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getReadlineRpm() {
		return readlineRpm;
	}
	public void setReadlineRpm(int redlineRpm) {
		this.readlineRpm = redlineRpm;
	}
	public int getMaxFuelVolume() {
		return maxFuelVolume;
	}
	public void setMaxFuelVolume(int maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}
	public String getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
}
