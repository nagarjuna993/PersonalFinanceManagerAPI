package com.javaj2eefsd.workshop.dao;

import com.javaj2eefsd.workshop.model.Registeruser;

public interface RegisterDao {
	public Registeruser registerUser(Registeruser registeruser) throws Exception;
	public Registeruser activateUser(String userId, Integer otp) throws Exception;
	

}
