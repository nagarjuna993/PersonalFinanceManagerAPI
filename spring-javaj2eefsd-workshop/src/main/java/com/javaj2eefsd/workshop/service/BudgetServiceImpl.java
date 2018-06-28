package com.javaj2eefsd.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaj2eefsd.workshop.dao.IBudgetDao;
import com.javaj2eefsd.workshop.model.Budget;
import com.javaj2eefsd.workshop.model.DateRange;

@Service
public class BudgetServiceImpl implements IBudgetService {
	
	@Autowired
    IBudgetDao budgetDaoImpl;
	@Override
	public List<Budget> getBudgetByDate(DateRange body) throws Exception {
		// TODO Auto-generated method stub
		//return null;
		return budgetDaoImpl.getAllBudget(body);
	}

}
