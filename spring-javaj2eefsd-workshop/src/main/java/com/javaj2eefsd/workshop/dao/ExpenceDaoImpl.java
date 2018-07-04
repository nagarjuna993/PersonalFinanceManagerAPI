/**
 *
 */
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
import org.threeten.bp.OffsetDateTime;
import com.javaj2eefsd.workshop.errormessageconfig.ExpenseErrorMassage;
import com.javaj2eefsd.workshop.model.Expense;
import com.mongodb.WriteResult;


/**
 * @author sathsubramanian ExpenseDao class is used to connect java code in database and create ,update.delete,retrieve
 *         and search expense data
 */
@Repository
public class ExpenceDaoImpl implements IExpenseDao {
    // logger instance
    private static final Logger log = LoggerFactory.getLogger(ExpenceDaoImpl.class);

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
        log.info("start expenseAllGet method in dao");
        List<Expense> expenseList = null;
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false));
            query.addCriteria(Criteria.where("loginId").is(expenseId));
            expenseList = mongoTemplate.find(query, Expense.class);
            log.info("successfuly excuted the query ");
        }
        catch (final Exception e) {
            log.error(e.getMessage());
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
        log.info("start expenseCreatePost method in dao");
        try {
            mongoTemplate.save(expenseObj);
        }
        catch (final Exception e) {
            log.error(e.getMessage());
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
        log.info("start expenseDeleteDelete method in dao");
        final WriteResult result;
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(id));
            // mongoTemplate.find(query, Expense.class);
            final Update update = new Update();
            update.set("isDelete", true);
            update.set("updatedDate", OffsetDateTime.now());
            result = mongoTemplate.updateFirst(query, update, Expense.class);
            if (!result.isUpdateOfExisting()) {
                log.info("somthing is wrong going to exception");
                throw new Exception(ExpenseErrorMassage.INVALIDEXPENSEID);
            }
            log.info("successfuly excuted the query ");
        }
        catch (final Exception e) {
            log.error(e.getMessage());
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
        log.info("start expenseUpdatePost method in dao");
        final WriteResult result;
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
            update.set("updateBy", expenseObj.getUpdateBy());
            result = mongoTemplate.updateFirst(query, update, Expense.class);
            if (!result.isUpdateOfExisting()) {
                log.info("somthing is wrong going to exception");
                throw new Exception(ExpenseErrorMassage.INVALIDEXPENSEID);
            }
        }
        catch (final Exception e) {
            log.error(e.getMessage());
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
        log.info("start expenseSearchGet method in dao");
        List<Expense> SearchList = null;
        int amount = 0;
        // check the key is number or not
        final String[] search = key.split("-");

        if (search[0].matches("-?\\d+(\\.\\d+)?")) {
            amount = Integer.parseInt(key);
        }
        log.info("validate the search key field");
        try {

            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false).andOperator(Criteria.where("loginId").is(search[1]))
                    .orOperator(Criteria.where("expenseName").is(search[0]),
                            Criteria.where("expenseAmount").is(amount), Criteria.where("expenseType").is(search[0]),
                            Criteria.where("createBy").is(search[0]), Criteria.where("updateBy").is(search[0])));

            SearchList = mongoTemplate.find(query, Expense.class);
            log.info("query excution is completed");
        }
        catch (final Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return SearchList;
    }

}
