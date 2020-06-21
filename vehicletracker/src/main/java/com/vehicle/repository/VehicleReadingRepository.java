package com.vehicle.repository;

import org.springframework.data.repository.CrudRepository;

import com.vehicle.entity.VehicleReading;

public interface VehicleReadingRepository extends CrudRepository<VehicleReading, String>{}
