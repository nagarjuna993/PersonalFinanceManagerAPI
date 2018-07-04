package com.javaj2eefsd.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.javaj2eefsd.workshop.dao.RegisterDao;
import com.javaj2eefsd.workshop.model.UserDetail;
import com.javaj2eefsd.workshop.model.Registeruser;

public interface LoginService {
	
	
	
	public UserDetail getLogin(UserDetail userdetail) throws Exception;

	
	
}
