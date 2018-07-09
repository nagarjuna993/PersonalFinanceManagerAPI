package com.javaj2eefsd.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.javaj2eefsd.workshop.dao.RegisterDao;
import com.javaj2eefsd.workshop.model.Investments;
import com.javaj2eefsd.workshop.model.Registeruser;

@Service

public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	RegisterDao registerObj;
	

	@Override
	public Registeruser registerUser(Registeruser registeruser)
			throws Exception {
		// TODO Auto-generated method stub
		return registerObj.registerUser(registeruser);
	}

	@Override
	public void activateUser(String userId,
			Integer otp) throws Exception {
		
		// TODO Auto-generated method stub
		registerObj.activateUser(userId,otp);
		
	}

}
