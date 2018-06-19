package com.javaj2eefsd.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;

import com.javaj2eefsd.workshop.dao.BankAccountDao;
import com.javaj2eefsd.workshop.model.BankAccount;

/**
 * @author Nagarjuna - BankAccountService interface used to validate the business logic and help to call the dao layer
 */
@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	BankAccountDao bankAccountDaoImpl;
	
	/**
     * getBankAccountAll method used to retrieve the BankAccount data from db
     *
     * @param BankAccountId
     * @return
     * @throws Exception
     */
	@Override
    public List<BankAccount> getBankAccountAll(String userId) throws Exception {
		return bankAccountDaoImpl.getBankAccountAll("1");
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
    	bankAccountObj.setCreatedDate(OffsetDateTime.now());
    	bankAccountObj.setUpdatedDate(OffsetDateTime.now());
    	bankAccountObj.setCreatedBy("1");
    	bankAccountObj.setUpdatedBy(bankAccountObj.getCreatedBy());
    	bankAccountObj.setIsDelete(false);
        return bankAccountDaoImpl.createBankAccount(bankAccountObj);
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
    	bankAccountDaoImpl.deleteBankAccount(bankAccountId);
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
    	return bankAccountDaoImpl.searchBankAccount(bankAccountKey);
    }
}
