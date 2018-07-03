package com.javaj2eefsd.workshop.service;

import com.javaj2eefsd.workshop.model.UserCurrency;
import com.javaj2eefsd.workshop.model.UserPassword;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;

public interface SettingsService {
	UserSettingsByEmailId getSettings(String emailId) throws Exception;
	UserCurrency  updateCurrency(UserCurrency usercurrencymodel) throws Exception;
	UserPassword  updatePassword(UserPassword userpasswordmodel) throws Exception;
	
}
