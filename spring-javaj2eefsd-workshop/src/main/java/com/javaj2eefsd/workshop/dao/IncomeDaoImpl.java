package com.javaj2eefsd.workshop.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.javaj2eefsd.workshop.model.Income;
import com.mongodb.WriteResult;

/**
 * @author Nagarjuna - IncomeDao class is used to connect java code in database and create,
 *         update, delete, retrieve and search income data.
 */
@Repository
public class IncomeDaoImpl implements IncomeDao {
	// logger instance
    private static final Logger log = LoggerFactory.getLogger(IncomeDaoImpl.class);
    
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
		log.info("[getIncomeAll] Start getIncomeAll method in DAO");
		List<Income> incomeList = null;
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false));
            query.addCriteria(Criteria.where("createdBy").is(userId));
            incomeList = mongoTemplate.find(query, Income.class);
            log.info("[getIncomeAll] Successfully executed query");
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
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
		log.info("[createIncome] Start createIncome method in DAO");
		try {
            mongoTemplate.save(incomeObj);
            log.info("[createIncome] Successfully saved data");
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
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
		log.info("[deleteIncome] Start deleteIncome method in DAO");
		final WriteResult result;
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("incomeId").is(incomeId));
            //mongoTemplate.findAndRemove(query, Income.class);
            final Update update = new Update();
            update.set("isDelete", true);
            result = mongoTemplate.updateFirst(query, update, Income.class);
            if (!result.isUpdateOfExisting()) {
                log.info("[deleteIncome] Somthing is wrong throwing exception");
                throw new Exception("Invalid income Id");
            }
            log.info("[deleteIncome] Successfully deleted data");
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
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
		log.info("[updateIncome] Start updateIncome method in DAO");
		final WriteResult result;
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("incomeId").is(incomeObj.getIncomeId()));
            final Update update = new Update();
            update.set("incomeAmount", incomeObj.getIncomeAmount());
            update.set("incomeType", incomeObj.getIncomeType());
            update.set("incomeDate", incomeObj.getIncomeDate());
            update.set("updatedDate", incomeObj.getUpdatedDate());
            update.set("updatedBy", incomeObj.getUpdatedBy());
            result = mongoTemplate.updateFirst(query, update, Income.class);
            if (!result.isUpdateOfExisting()) {
                log.info("[updateIncome] Somthing is wrong throwing exception");
                throw new Exception("Invalid income Id");
            }
            log.info("[updateIncome] Successfully updated data");
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
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
		log.info("[searchIncome] Start searchIncome method in DAO");
		List<Income> SearchList = null;
        int amount = 0;
        // check the key is number or not
        if (incomeKey.matches("-?\\d+(\\.\\d+)?")) {
            amount = Integer.parseInt(incomeKey);
        }
        log.info("[searchIncome] Validate the search key field");
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false).andOperator(Criteria.where("createdBy").is("1"))
                    .orOperator(Criteria.where("incomeAmount").is(amount),
                            Criteria.where("incomeType").is(incomeKey),
                            Criteria.where("incomeDate").is(incomeKey)));
            SearchList = mongoTemplate.find(query, Income.class);
            log.info("[searchIncome] Successfully executed query");
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        
        return SearchList;
	}
}
