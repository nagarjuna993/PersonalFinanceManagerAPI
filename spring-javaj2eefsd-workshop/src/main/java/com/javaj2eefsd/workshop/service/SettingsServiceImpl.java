package com.javaj2eefsd.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaj2eefsd.workshop.dao.SettingsDao;
import com.javaj2eefsd.workshop.model.UserCurrency;
import com.javaj2eefsd.workshop.model.UserPassword;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;
@Service
public class SettingsServiceImpl implements SettingsService{

	@Autowired
    SettingsDao settingsDaoImpl;
	@Override
	public UserSettingsByEmailId getSettings(String emailId) throws Exception {
		// TODO Auto-generated method stub
		
		return settingsDaoImpl.getSettings(emailId);
	}

	@Override
	public UserCurrency updateCurrency(UserCurrency usercurrencymodel)
			throws Exception {
		// TODO Auto-generated method stub
		return settingsDaoImpl.updateCurrency(usercurrencymodel);
	}

	@Override
	public UserPassword updatePassword(UserPassword userpasswordmodel)
			throws Exception {
		// TODO Auto-generated method stub
		return settingsDaoImpl.updatePassword(userpasswordmodel);
	}

}
