package com.vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alert {
	public static final String ALERT_TYPE_HIGH = "HIGH";
	public static final String ALERT_TYPE_LOW = "LOW";
	public static final String ALERT_TYPE_MEDIUM = "MEDIUM";
	
	@Id
	@GeneratedValue
	long id;
	
	long vehicleReadingId;
	String vin;
	String  alertType;
	String timestamp;
	String message;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getVehicleReadingId() {
		return vehicleReadingId;
	}
	public void setVehicleReadingId(long vehicleReadingId) {
		this.vehicleReadingId = vehicleReadingId;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getAlertType() {
		return alertType;
	}
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
