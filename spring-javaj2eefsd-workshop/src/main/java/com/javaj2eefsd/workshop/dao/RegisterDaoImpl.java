package com.javaj2eefsd.workshop.dao;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.javaj2eefsd.workshop.model.User;
import com.javaj2eefsd.workshop.util.EncryptionUtil;

@Repository
public class RegisterDaoImpl implements RegisterDao {
	
	// logger instance
    private static final Logger log = LoggerFactory.getLogger(RegisterDaoImpl.class);
    
	@Autowired
    MongoTemplate mongoTemplate;

	@Override
	public User registerUser(User registeruser) throws Exception  {
		// TODO Auto-generated method stub
		EncryptionUtil encObj = new EncryptionUtil();
		int otp = generateOTP();
		try {
			
			registeruser.setPassword(encObj.encrypt(registeruser.getPassword().trim())[0]);
			//Setting user status to False
			registeruser.setUserStatus(false);
			registeruser.setOtp(otp);
            mongoTemplate.save(registeruser);
          //this.sendEmail(registeruser.getEmailId(),registeruser.getOtp());
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
	
	public void sendEmail(String emailId, Integer otp) throws Exception {
		// TODO Auto-generated method stub
		
		final String username = "dakshinn@gmail.com";
		final String password = "";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailId));
			message.setSubject("Testing Subject");
			message.setText("Dear User"
					+ "\n\n Welcome to PFM!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public int generateOTP() {
		Random r = new Random();
	    return r.nextInt(999999);
	}
		



}
