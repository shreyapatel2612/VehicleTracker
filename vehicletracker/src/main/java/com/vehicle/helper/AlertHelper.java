package com.vehicle.helper;

import org.jeasy.rules.api.Facts;
import com.vehicle.entity.Alert;
import com.vehicle.entity.Vehicle;
import com.vehicle.entity.VehicleReading;
import com.vehicle.repository.AlertRepository;

public class AlertHelper {
	public static final String VEHICLE_READING = "vehicle_reading";
	public static final String VEHICLE = "vehicle";
	public static final String ALERT_REPOSITORY = "alert_repository";
	
	/* Rule evaluating EngineRpm conditions */
	public static boolean shouldTriggerEngineRpmRule(Facts facts) {
		return ((VehicleReading)facts.get(VEHICLE_READING)).getEngineRpm() > 
		((Vehicle)facts.get(VEHICLE)).getRedlineRpm();
	}
	
	/* Rule evaluating Fuel condition */
	public static boolean shouldTriggerFuelRule(Facts facts) {
		return ((VehicleReading)facts.get(VEHICLE_READING)).getFuelvolume() <
				(0.1 * ((Vehicle)facts.get(VEHICLE)).getMaxFuelVolume());
	}
	
	/* Rule evaluating Tires condition */
	public static boolean shouldTriggerTiersRule(Facts facts) {
		VehicleReading vehicleReading = (VehicleReading)facts.get(VEHICLE_READING);
		return (vehicleReading.getTires().getFrontLeft() < 32 || vehicleReading.getTires().getFrontLeft() > 36 ||
				vehicleReading.getTires().getFrontRight() < 32 || vehicleReading.getTires().getFrontRight() > 36 ||
				vehicleReading.getTires().getRearLeft() < 32 || vehicleReading.getTires().getRearLeft() > 36 ||
				vehicleReading.getTires().getRearRight() < 32 || vehicleReading.getTires().getRearRight() > 36);
	}
	
	/* Rule evaluating Engine Coolant or Engine light condition */
	public static boolean  shouldTriggerEngineCoolantRule (Facts facts) {
		return ((VehicleReading)facts.get(VEHICLE_READING)).isEngineCoolantLow() ||
				((VehicleReading)facts.get(VEHICLE_READING)).isCheckEngineLightOn();
	}
	
	/* Create EngineRpm Alert */
	public static void triggerEngineRpmAlert(Facts facts) {
		Alert alert = createAlert(facts);
		alert.setAlertType(Alert.ALERT_TYPE_HIGH);
		alert.setMessage("Engine rpm is greater than redline rpm");
		((AlertRepository)facts.get(ALERT_REPOSITORY)).save(alert);
	}
	
	/* Create Fuel Alert */
	public static void triggerFuleAlert(Facts facts) {
		Alert alert = createAlert(facts);
		alert.setAlertType(Alert.ALERT_TYPE_MEDIUM);
		alert.setMessage("Fuel volume is less than 10 percent of max fuel volume");
		((AlertRepository)facts.get(ALERT_REPOSITORY)).save(alert);
	}
	
	/* Create Tires Alert */
	public static void triggerTiresAlert(Facts facts) {
		Alert alert = createAlert(facts);
		alert.setAlertType(Alert.ALERT_TYPE_LOW);
		alert.setMessage("Tire pressure is not between 32psi to 36psi");
		((AlertRepository)facts.get(ALERT_REPOSITORY)).save(alert);
	}
	
	/* Create Engine coolant Alert */
	public static void triggerEngineCoolantRule(Facts facts) {
		Alert alert = createAlert(facts);
		alert.setAlertType(Alert.ALERT_TYPE_LOW);
		alert.setMessage("Engine coolant is low or engine light is on");
		((AlertRepository)facts.get(ALERT_REPOSITORY)).save(alert);
	}
	
	public static Alert createAlert(Facts facts) {
		Alert alert = new Alert();
		VehicleReading vehicleReading = (VehicleReading)facts.get(VEHICLE_READING);
		Vehicle vehicle = (Vehicle)facts.get(VEHICLE);
		alert.setTimestamp(vehicleReading.getTimestamp());
		alert.setVehicleReadingId(vehicleReading.getId());
		alert.setVin(vehicle.getVin());
		return alert;
	}
}
