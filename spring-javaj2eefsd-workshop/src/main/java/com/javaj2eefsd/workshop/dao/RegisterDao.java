package com.javaj2eefsd.workshop.dao;

import com.javaj2eefsd.workshop.model.Registeruser;

public interface RegisterDao {
	public Registeruser registerUser(Registeruser registeruser) throws Exception;
	public void activateUser(String userId, Integer otp) throws Exception;
	

}
