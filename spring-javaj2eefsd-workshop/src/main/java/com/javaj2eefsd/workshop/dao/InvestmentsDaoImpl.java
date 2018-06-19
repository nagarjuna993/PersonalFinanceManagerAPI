package com.javaj2eefsd.workshop.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.javaj2eefsd.workshop.model.Investments;

/**
 * @author Nagarjuna - InvestmentsDao class is used to connect java code in database and create,
 *         update, delete, retrieve and search income data.
 */
@Repository
public class InvestmentsDaoImpl implements InvestmentsDao {
	
	@Autowired
    MongoTemplate mongoTemplate;
	
	/**
     * getInvestmentsAll method used to retrieve the Investments data from db
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
	@Override
    public List<Investments> getInvestmentsAll(String userId) throws Exception {
		List<Investments> investmentsList = null;
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false));
            query.addCriteria(Criteria.where("createdBy").is(userId));
            investmentsList = mongoTemplate.find(query, Investments.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
        
        return investmentsList;
    }

    /**
     * createInvestments method used to create new Investments data in db
     *
     * @param InvestmentsObj
     * @return
     * @throws Exception
     */
	@Override
    public Investments createInvestments(Investments investmentsObj) throws Exception {
		try {
            mongoTemplate.save(investmentsObj);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
		
        return investmentsObj;
	}

    /**
     * deleteInvestments method used to delete the Investments data based on user input
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
	@Override
    public void deleteInvestments(String investmentsId) throws Exception {
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("investmentsId").is(investmentsId));
            //mongoTemplate.findAndRemove(query, Investments.class);
            final Update update = new Update();
            update.set("isDelete", true);
            mongoTemplate.updateFirst(query, update, Investments.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
	}

    /**
     * updateInvestments method used to update the Investments data in db
     *
     * @param InvestmentsObj
     * @return
     * @throws Exception
     */
	@Override
    public Investments updateInvestments(Investments investmentsObj) throws Exception {
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("investmentsId").is(investmentsObj.getInvestmentsId()));
            final Update update = new Update();
            update.set("investmentsAmount", investmentsObj.getInvestmentsAmount());
            update.set("investmentsType", investmentsObj.getInvestmentsType());
            update.set("investmentsDate", investmentsObj.getInvestmentsDate());
            update.set("updatedDate", investmentsObj.getUpdatedDate());
            update.set("updatedBy", investmentsObj.getUpdatedBy());
            mongoTemplate.updateFirst(query, update, Investments.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
		
        return investmentsObj;
	}

    /**
     * searchInvestments method used to search the Investments data based on user inputs
     *
     * @param InvestmentsKey
     * @return
     * @throws Exception
     */
	@Override
    public List<Investments> searchInvestments(String investmentsKey) throws Exception {
		List<Investments> SearchList = null;
        int amount = 0;
        // check the key is number or not
        if (investmentsKey.matches("-?\\d+(\\.\\d+)?")) {
            amount = Integer.parseInt(investmentsKey);
        }
        
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false).andOperator(Criteria.where("createdBy").is("1"))
                    .orOperator(Criteria.where("investmentsAmount").is(amount),
                            Criteria.where("investmentsType").is(investmentsKey),
                            Criteria.where("investmentsDate").is(investmentsKey)));
            SearchList = mongoTemplate.find(query, Investments.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
        
        return SearchList;
	}
}
