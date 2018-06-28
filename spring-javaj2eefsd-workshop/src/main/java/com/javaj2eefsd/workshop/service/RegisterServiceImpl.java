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
	
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public Registeruser registerUser(Registeruser registeruser)
			throws Exception {
		// TODO Auto-generated method stub
		return registerObj.registerUser(registeruser);
	}

	/*@Override
	public Registeruser activateUser(String userId, int otp)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		
		registeruser.setUserId("5b323b33df75711f081d5c13");
		
		if(otp==registeruser.getOtp())
			registeruser.setUserStatus(true);
		
		return registeruser;
		
		
		final Query query = new Query();
        query.addCriteria(Criteria.where("investmentsId").is(investmentsId));
        //mongoTemplate.findAndRemove(query, Investments.class);
        final Update update = new Update();
        update.set("isDelete", true);
        mongoTemplate.updateFirst(query, update, Investments.class);
		
	}*/

	@Override
	public Registeruser activateUser(String userId,
			Integer otp) throws Exception {
		// TODO Auto-generated method stub
		
		
		return registerObj.activateUser(userId,otp);
		
		//return null;
	}

}
