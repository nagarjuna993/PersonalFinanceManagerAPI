package com.javaj2eefsd.workshop.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.threeten.bp.OffsetDateTime;

import com.javaj2eefsd.workshop.model.Budget;
import com.javaj2eefsd.workshop.model.DateRange;
import com.javaj2eefsd.workshop.model.Expense;
import com.javaj2eefsd.workshop.model.Income;
import com.javaj2eefsd.workshop.model.Investments;

@Repository
public class BudgetDaoImpl implements IBudgetDao {
	
	// create object from MongoTemplate
    @Autowired
    MongoTemplate mongoTemplate;
	private List<Expense> expenseList;
	private List<Income> incomeList;
	private List<Investments> investmentsList;
	private List<Budget> budgetList;

	@Override
	public List<Budget> getAllBudget(DateRange body) throws Exception {
		budgetList = null;
		Date dateFromDate = new Date(body.getFromExpenseDate().toInstant().toEpochMilli());
		Date dateToDate = new Date(body.getToExpenseDate().toInstant().toEpochMilli());
		try {
			final Query query = new Query();
            //query.addCriteria(Criteria.where("isDelete").is(false));
            //query.addCriteria(Criteria.where("loginId").is(body));	
            query.addCriteria(
            	    new Criteria().andOperator(
            	        Criteria.where("createdDate.dateTime").gte(dateFromDate),
            	        Criteria.where("createdDate.dateTime").lte(dateToDate)
            	    )
            	);
            expenseList = mongoTemplate.find(query, Expense.class);
            incomeList = mongoTemplate.find(query, Income.class);
            investmentsList = mongoTemplate.find(query, Investments.class);
            budgetList = (List)expenseList;
            budgetList.addAll((List)incomeList);
            budgetList.addAll((List)investmentsList);
		} catch(final Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return budgetList;
	}

}
