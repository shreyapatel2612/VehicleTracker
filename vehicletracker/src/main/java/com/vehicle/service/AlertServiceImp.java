package com.vehicle.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.entity.Alert;
import com.vehicle.repository.AlertRepository;

@Service
public class AlertServiceImp implements AlertService{
	
	@Autowired
	AlertRepository alertRepository;
	
	@Transactional
	public Alert create(Alert alert) {
		return alertRepository.save(alert);
	}

}
