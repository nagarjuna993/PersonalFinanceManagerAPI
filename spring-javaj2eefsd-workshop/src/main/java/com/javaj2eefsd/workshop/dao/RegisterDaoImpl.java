package com.javaj2eefsd.workshop.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.javaj2eefsd.workshop.model.Investments;
import com.javaj2eefsd.workshop.model.User;

@Repository
public class RegisterDaoImpl implements RegisterDao {
	
	// logger instance
    private static final Logger log = LoggerFactory.getLogger(RegisterDaoImpl.class);
    
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public User registerUser(User registeruser) throws Exception  {
		// TODO Auto-generated method stub
		try {
			//Setting user status to False
			//TODO: Set user status to true after impl
			registeruser.setUserStatus(true);
            mongoTemplate.save(registeruser);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
		
        return registeruser;
	}

	@Override
	public void activateUser(String userId, Integer otp)
			throws Exception {
		// TODO Auto-generated method stub
		
		
try {
			
			List<User> registeruserList = null;
			
			log.info(userId+ "OTP" +otp );
			
            final Query query = new Query();
            //query.addCriteria(Criteria.where("userId").is(registeruser.getUserId())) ;
            
            query.addCriteria(Criteria.where("userId").is(userId)) ;
            
            registeruserList = mongoTemplate.find(query, User.class);
            
            //Updating the user status starts here
            final Update update = new Update();
            
            if(otp==registeruserList.get(0).getOtp())
            	update.set("userStatus", true);
            
            mongoTemplate.updateFirst(query, update, User.class);
            //Updating the user status ends here
            log.info(" After update :: "+" userId ==> "+userId + " otp ==> "+otp + registeruserList.get(0).getOtp()+" "+registeruserList.get(0).getLastName());
            

        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
		

	}
		



}
