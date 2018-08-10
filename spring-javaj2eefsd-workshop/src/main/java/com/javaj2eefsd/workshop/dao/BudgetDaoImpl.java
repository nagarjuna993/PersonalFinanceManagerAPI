package com.javaj2eefsd.workshop.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
	//public List<Budget> getAllBudget(DateRange body) throws Exception {
	public ArrayList getAllBudget(DateRange body) throws Exception {
		ArrayList expenseLists = new ArrayList<>();
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
            
	          //this.setState({ plotdata: [[Date.UTC(2018,7,2),1500], [Date.UTC(2018,7,15),2200], [Date.UTC(2018,7,31),600], [Date.UTC(2018,7,31),800]] })
        	for (int i = 0; i < expenseList.size(); i++) {
        		ArrayList dummy = new ArrayList<>();
        		long epochMilli = expenseList.get(i).getCreatedDate().toInstant().toEpochMilli();
        		//Date date = new Date(epochMilli);
        		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date= new Date(epochMilli);  
                String dateString = formatter.format(date);
                //Date TestDate = DateTimeOffset.Parse(dateString).UtcDateTime;
        		dummy.add(epochMilli);
        		dummy.add(expenseList.get(i).getExpenseAmount());
        		System.out.println(expenseList.get(i).getCreatedDate() + "|" + expenseList.get(i).getExpenseAmount());
        		expenseLists.add(dummy);
        	}

            //budgetList.addAll((List)incomeList);
            //budgetList.addAll((List)investmentsList);
		} catch(final Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return expenseLists;
	}

}
