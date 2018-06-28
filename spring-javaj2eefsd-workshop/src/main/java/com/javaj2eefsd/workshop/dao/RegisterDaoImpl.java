package com.javaj2eefsd.workshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.javaj2eefsd.workshop.model.Investments;
import com.javaj2eefsd.workshop.model.Registeruser;

@Repository
public class RegisterDaoImpl implements RegisterDao {
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public Registeruser registerUser(Registeruser registeruser) throws Exception  {
		// TODO Auto-generated method stub
		try {
			//Setting user status to False
			registeruser.setUserStatus(false);
            mongoTemplate.save(registeruser);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
		
        return registeruser;
	}

	@Override
	public Registeruser activateUser(String userId, Integer otp)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		try {
			
			List<Registeruser> registeruserList = null;
			
			System.out.println(userId+ "OTP" +otp );
			
            final Query query = new Query();
            //query.addCriteria(Criteria.where("userId").is(registeruser.getUserId())) ;
            
            query.addCriteria(Criteria.where("userId").is(userId)) ;
            
            registeruserList = mongoTemplate.find(query, Registeruser.class);
            
            //Updating the user status starts here
            final Update update = new Update();
            
            if(otp==registeruserList.get(0).getOtp())
            	update.set("userStatus", true);
            
            mongoTemplate.updateFirst(query, update, Registeruser.class);
            //Updating the user status ends here
            System.out.println(" After update :: "+" userId ==> "+userId + " otp ==> "+otp + registeruserList.get(0).getFirstName()+" "+registeruserList.get(0).getLastName());
            
          //mongoTemplate.findAndRemove(query, Investments.class);
            if(otp==registeruserList.get(0).getOtp())
            {
            	//registeruser.setUserStatus(true);
            	registeruserList.get(0).setUserStatus(true);
    		}
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
		
		
		
		
		return new Registeruser();
	}
		



}
