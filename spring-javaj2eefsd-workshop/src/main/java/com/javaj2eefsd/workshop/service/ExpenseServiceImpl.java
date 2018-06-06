/**
 *
 */
package com.javaj2eefsd.workshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;
import com.javaj2eefsd.workshop.dao.IExpenseDao;
import com.javaj2eefsd.workshop.model.Expense;


/**
 * @author sathsubramanian ExpenseService class used to validate the business logic and help to call the dao layer
 */
@Service
public class ExpenseServiceImpl implements IExpenseService {
    // create object from IExpenseDao
    @Autowired
    IExpenseDao expenseDaoImpl;

    /**
     * expenseAllGet method used to retrieve the login user data and non-deleted data help to call dao methods
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public List<Expense> expenseAllGet(final String expenseId) throws Exception {
        // TODO Auto-generated method stub
        return expenseDaoImpl.expenseAllGet(expenseId);
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
        expenseObj.setCreatedDate(OffsetDateTime.now());
        // expenseObj.setExpenseDate(dateUtils());
        expenseObj.setUpdatedDate(OffsetDateTime.now());
        expenseObj.setIsDelete(true);
        expenseObj.setCreateBy("sathish");
        expenseObj.setUpdBy(expenseObj.getCreateBy());
        expenseObj.setLoginId("1");
        return expenseDaoImpl.expenseCreatePost(expenseObj);
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
        expenseDaoImpl.expenseDeleteDelete(id);

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
        expenseObj.setUpdatedDate(OffsetDateTime.now());
        expenseObj.setUpdBy("sathish");
        return expenseDaoImpl.expenseUpdatePost(expenseObj);
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
        // TODO Auto-generated method stub
        return expenseDaoImpl.expenseSearchGet(key);
    }

}
