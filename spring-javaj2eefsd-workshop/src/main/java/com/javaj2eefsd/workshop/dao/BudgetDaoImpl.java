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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
	public JSONArray getAllBudget(DateRange body) throws Exception {
		ArrayList investmentLists = new ArrayList<>();
		ArrayList incomeLists = new ArrayList<>();	
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
        	
            System.out.println("Investment List");
        	for (int i = 0; i < investmentsList.size(); i++) {
        		ArrayList dummy = new ArrayList<>();
        		long epochMilli = investmentsList.get(i).getCreatedDate().toInstant().toEpochMilli();
        		dummy.add(epochMilli);
        		dummy.add(investmentsList.get(i).getInvestmentsAmount());
        		System.out.println(investmentsList.get(i).getCreatedDate() + "|" + investmentsList.get(i).getInvestmentsAmount());
        		investmentLists.add(dummy);
        	}
        	
        	System.out.println("Income List");
        	for (int i = 0; i < incomeList.size(); i++) {
        		ArrayList dummy = new ArrayList<>();
        		long epochMilli = incomeList.get(i).getCreatedDate().toInstant().toEpochMilli();
        		dummy.add(epochMilli);
        		dummy.add(incomeList.get(i).getIncomeAmount());
        		System.out.println(incomeList.get(i).getCreatedDate() + "|" + incomeList.get(i).getIncomeAmount());
        		incomeLists.add(dummy);
        	}

        	System.out.println("Expense List");
        	for (int i = 0; i < expenseList.size(); i++) {
        		ArrayList dummy = new ArrayList<>();
        		long epochMilli = expenseList.get(i).getCreatedDate().toInstant().toEpochMilli();
        		dummy.add(epochMilli);
        		dummy.add(expenseList.get(i).getExpenseAmount());
        		System.out.println(expenseList.get(i).getCreatedDate() + "|" + expenseList.get(i).getExpenseAmount());
        		expenseLists.add(dummy);
        	}
        	
		} catch(final Exception e) {
			throw new Exception(e.getMessage());
		}

		JSONObject jo = new JSONObject();
		JSONObject jo1 = new JSONObject();
		JSONArray ja = new JSONArray();
		
		System.out.println(body.getBudgetType());
		if(body.getBudgetType().equalsIgnoreCase("Investment")) {
			jo.put("name", "Investment");
			jo.put("data", investmentLists);
			ja.add(jo);
		} else if(body.getBudgetType().equalsIgnoreCase("Income")) {
			jo.put("name", "Income");
			jo.put("data", incomeLists);
			ja.add(jo);
		} else if(body.getBudgetType().equalsIgnoreCase("Expense")) {
			jo.put("name", "Expense");
			jo.put("data", expenseLists);
			ja.add(jo);
		} else if(body.getBudgetType().equalsIgnoreCase("Income Vs Expense")) {
			jo.put("name", "Income");
			jo.put("data", incomeLists);
			ja.add(0, jo);
			jo1.put("name", "Expense");
			jo1.put("data", expenseLists);
			ja.add(1, jo1);
		} else if(body.getBudgetType().equalsIgnoreCase("Income Vs Investment")) {
			jo.put("name", "Income");
			jo.put("data", incomeLists);
			ja.add(0, jo);
			jo1.put("name", "Investment");
			jo1.put("data", investmentLists);
			ja.add(1, jo1);
			
		} 		
		return ja;
	}

}

