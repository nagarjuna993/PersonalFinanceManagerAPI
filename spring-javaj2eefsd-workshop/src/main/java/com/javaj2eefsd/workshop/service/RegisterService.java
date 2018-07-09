package com.javaj2eefsd.workshop.service;

import com.javaj2eefsd.workshop.model.Registeruser;

public interface RegisterService {
	
	public Registeruser registerUser(Registeruser registeruser) throws Exception;
	public void activateUser(String userId, Integer otp) throws Exception;

}
