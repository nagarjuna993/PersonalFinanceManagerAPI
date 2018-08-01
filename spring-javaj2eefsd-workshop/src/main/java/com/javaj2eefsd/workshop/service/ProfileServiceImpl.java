package com.javaj2eefsd.workshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaj2eefsd.workshop.dao.ProfileDao;
import com.javaj2eefsd.workshop.model.Profile;

/**
 * 
 * @author Kumar - ProfileServiceImpl class is used to validate the business logic and to call the Profile layer Database Access Object for profile to connect with Database
 * to view and update the user profile data.
 */

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileDao profileDao;
	
	/**
     * getProfileDetails method used to retrieve the profile data from Database
     *
     * @param emailId
     * @return
     * @throws Exception
     */
	
	@Override
	public Profile getProfileDetails(String emailId) throws Exception {
		return profileDao.getProfileDetails(emailId);
	}
	
	/**
     * updateProfileDetails method used to retrieve the profile data from Database
     *
     * @param profileObj
     * @return
     * @throws Exception
     */
	@Override
	public Profile updateProfileDetails(Profile profileObj) throws Exception {
//		profileObj.setCompanyName("Amex");
//		profileObj.setContactNumber("252525252525");
//		profileObj.setEmaiId("kr2@kr");
//		profileObj.setFirstName("Ayush");
//		profileObj.setLastName("Agarwal");
//		profileObj.setProfileImage("myProfile");
//		profileObj.setIsDelete(true);
		
		profileObj.setCompanyName(profileObj.getCompanyName());
		profileObj.setContactNumber(profileObj.getContactNumber());
		profileObj.setEmaiId(profileObj.getEmaiId());
		profileObj.setFirstName(profileObj.getFirstName());
		profileObj.setLastName(profileObj.getLastName());
		profileObj.setProfileImage(profileObj.getProfileImage());
		profileObj.setIsDelete(profileObj.getIsDelete());
		
		return profileDao.updateProfileDetails(profileObj);
	}

	
	
}
