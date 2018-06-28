package com.javaj2eefsd.workshop.service;

import java.util.List;

import com.javaj2eefsd.workshop.model.Budget;
import com.javaj2eefsd.workshop.model.DateRange;

public interface IBudgetService {
	
	List<Budget> getBudgetByDate(DateRange body) throws Exception;

}

