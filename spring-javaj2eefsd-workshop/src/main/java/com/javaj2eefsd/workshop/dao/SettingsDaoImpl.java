package com.javaj2eefsd.workshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.javaj2eefsd.workshop.model.UserCurrency;
import com.javaj2eefsd.workshop.model.UserPassword;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;
@Repository
public class SettingsDaoImpl implements SettingsDao{
	@Autowired
	MongoTemplate mongoTemplate;
	@Override
	public UserSettingsByEmailId getSettings(String emailId) throws Exception {
		
		UserSettingsByEmailId userSettings = null;

		try {
			final Query query = new Query();
			query.addCriteria(Criteria.where("emailId").is(emailId));
			userSettings = mongoTemplate.findOne(query, UserSettingsByEmailId.class);
		}
		catch (final Exception e) {
			throw new Exception(e.getMessage());
		}
		return userSettings;
	}

	@Override
	public UserCurrency updateCurrency(UserCurrency usercurrencymodel)
			throws Exception {

		String emailId = usercurrencymodel.getEmailId();
		String newCurrency = usercurrencymodel.getNewCurrency();
		String oldCurrency = usercurrencymodel.getOldCurrency();


		try {
			UserCurrency usercurrency=null;
			final Query query = new Query();
			query.addCriteria(Criteria.where("emailId").is(emailId));
			usercurrency = mongoTemplate.findOne(query, UserCurrency.class);
			final Update update = new Update();
			System.out.println("Old currency"+oldCurrency );
			System.out.println("New currency"+newCurrency);
			update.set("currency",newCurrency);
			mongoTemplate.updateFirst(query, update, UserCurrency.class);

		}
		catch (final Exception e) {
			
			throw new Exception(e.getMessage());
		}
		return new UserCurrency();
	}



	@Override
	public UserPassword updatePassword(UserPassword userpasswordmodel)
			throws Exception {


		String emailId1 = userpasswordmodel.getEmailId();
		String newPassword = userpasswordmodel.getNewPassword();
		String confirmPassword = userpasswordmodel.getConfirmPassword();

		try {

			UserPassword userpassword=null;
			final Query query = new Query();
			query.addCriteria(Criteria.where("emailId").is(emailId1));
			userpassword = mongoTemplate.findOne(query, UserPassword.class);
			final Update update = new Update();
			System.out.println("new password"+newPassword);
			System.out.println("ConfirmPassword"+confirmPassword);
			if(newPassword.equals(confirmPassword))
			{
				update.set("password",newPassword);
				mongoTemplate.updateFirst(query, update, UserPassword.class);
			}	
			else
			{
				throw new Exception();	
			}

		}
		catch (final Exception e) {
			
			throw new Exception(e.getMessage());
		}
		return new UserPassword();
	}

}


