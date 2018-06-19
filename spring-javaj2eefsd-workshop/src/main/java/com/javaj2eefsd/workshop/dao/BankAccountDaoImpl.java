package com.javaj2eefsd.workshop.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.javaj2eefsd.workshop.model.BankAccount;

/**
 * @author Nagarjuna - BankAccountDao class is used to connect java code in database and create,
 *         update, delete, retrieve and search income data.
 */
@Repository
public class BankAccountDaoImpl implements BankAccountDao {
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	/**
     * getBankAccountAll method used to retrieve the BankAccount data from db
     *
     * @param BankAccountId
     * @return
     * @throws Exception
     */
	@Override
    public List<BankAccount> getBankAccountAll(String userId) throws Exception {
		List<BankAccount> bankAccountList = null;
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false));
            query.addCriteria(Criteria.where("createdBy").is(userId));
            bankAccountList = mongoTemplate.find(query, BankAccount.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
        
        return bankAccountList;
    }

    /**
     * createBankAccount method used to create new BankAccount data in db
     *
     * @param BankAccountObj
     * @return
     * @throws Exception
     */
	@Override
    public BankAccount createBankAccount(BankAccount bankAccountObj) throws Exception {
		try {
            mongoTemplate.save(bankAccountObj);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
		
        return bankAccountObj;
	}

    /**
     * deleteBankAccount method used to delete the BankAccount data based on user input
     *
     * @param BankAccountId
     * @return
     * @throws Exception
     */
	@Override
    public void deleteBankAccount(String bankAccountId) throws Exception {
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("bankAccountId").is(bankAccountId));
            //mongoTemplate.findAndRemove(query, BankAccount.class);
            final Update update = new Update();
            update.set("isDelete", true);
            mongoTemplate.updateFirst(query, update, BankAccount.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
	}

    /**
     * searchBankAccount method used to search the BankAccount data based on user inputs
     *
     * @param BankAccountKey
     * @return
     * @throws Exception
     */
	@Override
    public List<BankAccount> searchBankAccount(String bankAccountKey) throws Exception {
		List<BankAccount> SearchList = null;
        
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false).andOperator(Criteria.where("createdBy").is("1"))
                    .orOperator(Criteria.where("accountNumber").is(bankAccountKey),
                            Criteria.where("accountHolderName").is(bankAccountKey),
                            Criteria.where("accountType").is(bankAccountKey),
                            Criteria.where("bankName").is(bankAccountKey),
                            Criteria.where("ifscCode").is(bankAccountKey)));
            SearchList = mongoTemplate.find(query, BankAccount.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
        
        return SearchList;
	}
}
