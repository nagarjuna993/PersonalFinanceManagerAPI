/**
 *
 */
package com.javaj2eefsd.workshop.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.javaj2eefsd.workshop.model.Expense;


/**
 * @author sathsubramanian ExpenseDao class is used to connect java code in database and create ,update.delete,retrieve
 *         and search expense data
 */
@Repository
public class ExpenceDaoImpl implements IExpenseDao {
    // create object from MongoTemplate
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * expenseAllGet method used to retrieve the login user data and non-deleted data in db
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public List<Expense> expenseAllGet(final String expenseId) throws Exception {
        // TODO Auto-generated method stub
        List<Expense> expenseList = null;
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(true));
            query.addCriteria(Criteria.where("loginId").is(expenseId));
            expenseList = mongoTemplate.find(query, Expense.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
        return expenseList;
    }

    /**
     * expenseCreatePost method used to create new expense data in db
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public Expense expenseCreatePost(final Expense expenseObj) throws Exception {
        // TODO Auto-generated method stub
        try {
            mongoTemplate.save(expenseObj);
        }
        catch (final Exception e) {
            // TODO: handle exception
            throw new Exception(e.getMessage());
        }
        return expenseObj;
    }

    /**
     * expenseDeleteDelete method used to delete the expense data based on user input
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public void expenseDeleteDelete(final String id) throws Exception {
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(id));
            // mongoTemplate.find(query, Expense.class);
            final Update update = new Update();
            update.set("isDelete", false);
            mongoTemplate.updateFirst(query, update, Expense.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    /**
     * expenseUpdatePost method used to update the expense data in db
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public Expense expenseUpdatePost(final Expense expenseObj) throws Exception {
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(expenseObj.getExpenseId()));
            // mongoTemplate.find(query, Expense.class);
            final Update update = new Update();
            update.set("expenseName", expenseObj.getExpenseName());
            update.set("expenseAmount", expenseObj.getExpenseAmount());
            update.set("expenseDate", expenseObj.getExpenseDate());
            update.set("expenseType", expenseObj.getExpenseType());
            update.set("updatedDate", expenseObj.getUpdatedDate());
            update.set("updBy", expenseObj.getUpdBy());
            mongoTemplate.updateFirst(query, update, Expense.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
        return expenseObj;
    }

    /**
     * expenseSearchGet method used to search the expense data based on user inputs
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public List<Expense> expenseSearchGet(final String key) throws Exception {
        List<Expense> SearchList = null;
        int amount = 0;
        // check the key is number or not
        if (key.matches("-?\\d+(\\.\\d+)?")) {
            amount = Integer.parseInt(key);
        }
        try {

            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(true).andOperator(Criteria.where("loginId").is("1"))
                    .orOperator(Criteria.where("expenseName").is(key),
                            Criteria.where("expenseAmount").is(amount), Criteria.where("expenseDate").is(key),
                            Criteria.where("expenseSpentFrom").is(key)));
            SearchList = mongoTemplate.find(query, Expense.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
        return SearchList;
    }

}
