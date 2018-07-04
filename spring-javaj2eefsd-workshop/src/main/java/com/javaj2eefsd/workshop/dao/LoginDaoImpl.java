package com.javaj2eefsd.workshop.dao;
import com.javaj2eefsd.workshop.model.UserDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.javaj2eefsd.workshop.model.UserDetail;
import com.javaj2eefsd.workshop.model.Registeruser;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public UserDetail getLogin(UserDetail userdetail ) throws Exception {
		try {

			UserDetail loginuser = null;
			
			final Query query = new Query();
			query.addCriteria(Criteria.where("emailId").is(userdetail.getEmailId()).and("password").is(userdetail.getPassword()));

			loginuser = mongoTemplate.findOne(query, UserDetail.class);

			if(loginuser == null) {
				throw new Exception("No user found");
			}

			else if(loginuser.getUserStatus() == false) {
				throw new Exception("User is not active");
			}
		}
		catch (final Exception e) {
			throw new Exception(e.getMessage());
		}

		return userdetail;
	}

}
