package com.javaj2eefsd.workshop.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.javaj2eefsd.workshop.api.ApiException;
import com.javaj2eefsd.workshop.model.UserDetail;
import com.javaj2eefsd.workshop.util.PFMConstants;
import com.javaj2eefsd.workshop.util.EncryptionUtil;
import com.javaj2eefsd.workshop.util.EncryptionUtil.Encrypter;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    MongoTemplate mongoTemplate;
    
    private static final Logger log = LoggerFactory.getLogger(LoginDaoImpl.class);

    @Override
    public UserDetail getLogin(final UserDetail userdetail) throws Exception {
    	UserDetail loginuser = null;
        EncryptionUtil encObj = new EncryptionUtil();
    	try {
            final Query query = new Query();
            final String ENCRYPTION_KEY = "YNYNWKLIJLKJFJALJLAJFJFJY";
            final Encrypter dencrypter = new Encrypter("DESede", ENCRYPTION_KEY);
            userdetail.setPassword(encObj.encrypt(userdetail.getPassword().trim())[0]);
            query.addCriteria(
                    Criteria.where("emailId").is(userdetail.getEmailId()).and("password").is(userdetail.getPassword()));
            loginuser = mongoTemplate.findOne(query, UserDetail.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
    	
    	if (loginuser == null)
            throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_EMAILID_PASSWORD);
        else if (loginuser.getUserStatus() == false)
        	throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.USER_NOT_ACTIVE);

        return userdetail;
    }

}
