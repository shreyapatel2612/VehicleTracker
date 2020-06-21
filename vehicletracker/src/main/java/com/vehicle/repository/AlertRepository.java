package com.vehicle.repository;

import org.springframework.data.repository.CrudRepository;

import com.vehicle.entity.Alert;

public interface AlertRepository extends CrudRepository<Alert, String>{

}
