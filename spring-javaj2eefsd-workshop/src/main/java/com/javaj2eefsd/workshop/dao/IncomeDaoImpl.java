package com.javaj2eefsd.workshop.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.javaj2eefsd.workshop.model.Income;

/**
 * @author Nagarjuna - IncomeDao class is used to connect java code in database and create,
 *         update, delete, retrieve and search income data.
 */
@Repository
public class IncomeDaoImpl implements IncomeDao {
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	/**
     * getIncomeAll method used to retrieve the income data from db
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
	@Override
    public List<Income> getIncomeAll(String userId) throws Exception {
		List<Income> incomeList = null;
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false));
            query.addCriteria(Criteria.where("createdBy").is(userId));
            incomeList = mongoTemplate.find(query, Income.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
        
        return incomeList;
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
		try {
            mongoTemplate.save(incomeObj);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
		
        return incomeObj;
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
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("incomeId").is(incomeId));
            //mongoTemplate.findAndRemove(query, Income.class);
            final Update update = new Update();
            update.set("isDelete", true);
            mongoTemplate.updateFirst(query, update, Income.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
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
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("incomeId").is(incomeObj.getIncomeId()));
            final Update update = new Update();
            update.set("incomeAmount", incomeObj.getIncomeAmount());
            update.set("incomeType", incomeObj.getIncomeType());
            update.set("incomeDate", incomeObj.getIncomeDate());
            update.set("updatedDate", incomeObj.getUpdatedDate());
            update.set("updatedBy", incomeObj.getUpdatedBy());
            mongoTemplate.updateFirst(query, update, Income.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
		
        return incomeObj;
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
		List<Income> SearchList = null;
        int amount = 0;
        // check the key is number or not
        if (incomeKey.matches("-?\\d+(\\.\\d+)?")) {
            amount = Integer.parseInt(incomeKey);
        }
        
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false).andOperator(Criteria.where("createdBy").is("1"))
                    .orOperator(Criteria.where("incomeAmount").is(amount),
                            Criteria.where("incomeType").is(incomeKey),
                            Criteria.where("incomeDate").is(incomeKey)));
            SearchList = mongoTemplate.find(query, Income.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
        
        return SearchList;
	}
}
