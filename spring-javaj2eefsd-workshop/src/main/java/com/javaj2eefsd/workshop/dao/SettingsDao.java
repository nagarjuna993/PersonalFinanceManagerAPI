package com.javaj2eefsd.workshop.dao;

import com.javaj2eefsd.workshop.model.UserCurrency;
import com.javaj2eefsd.workshop.model.UserPassword;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;

public interface SettingsDao {
	
	UserSettingsByEmailId getSettings(String emailId) throws Exception;
	UserPassword  updatePassword(UserPassword userpasswordmodel) throws Exception;
	UserCurrency updateCurrency(UserCurrency usercurrencymodel) throws Exception;
	
}
