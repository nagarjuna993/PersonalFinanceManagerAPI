package com.javaj2eefsd.workshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;
import com.javaj2eefsd.workshop.dao.IncomeDao;
import com.javaj2eefsd.workshop.model.Income;

/**
 * @author Nagarjuna - IncomeService interface used to validate the business logic and help to call the dao layer
 */
@Service
public class IncomeServiceImpl implements IncomeService {
	
	@Autowired
    IncomeDao incomeDaoImpl;
	
	/**
     * getIncomeAll method used to retrieve the income data from db
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
	@Override
    public List<Income> getIncomeAll(String userId) throws Exception {
		return incomeDaoImpl.getIncomeAll("1");
    }

    /**
     * createIncome method used to create new income data in db
     *
     * @param incomeObj
     * @return
     * @throws Exception
     */
    @Override
    public Income createIncome(Income incomeObj) throws Exception {
    	incomeObj.setCreatedDate(OffsetDateTime.now());
    	incomeObj.setUpdatedDate(OffsetDateTime.now());
    	incomeObj.setCreatedBy("1");
        return incomeDaoImpl.createIncome(incomeObj);
    }

    /**
     * deleteIncome method used to delete the income data based on user input
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
    @Override
    public void deleteIncome(String incomeId) throws Exception {
    	incomeDaoImpl.deleteIncome(incomeId);
    }

    /**
     * updateIncome method used to update the income data in db
     *
     * @param incomeObj
     * @return
     * @throws Exception
     */
    @Override
    public Income updateIncome(Income incomeObj) throws Exception {
    	incomeObj.setUpdatedDate(OffsetDateTime.now());
    	incomeObj.setCreatedBy("1");
        return incomeDaoImpl.updateIncome(incomeObj);
    }

    /**
     * searchIncome method used to search the income data based on user inputs
     *
     * @param incomeKey
     * @return
     * @throws Exception
     */
    @Override
    public List<Income> searchIncome(String incomeKey) throws Exception {
    	return incomeDaoImpl.searchIncome(incomeKey);
    }
}
